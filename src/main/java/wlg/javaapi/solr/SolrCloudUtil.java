package wlg.javaapi.solr;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest.ACTION;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.ExecutorUtil;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.common.util.SolrjNamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wlg.apiutil.httputil.HttpUtil;
import wlg.javaapi.solr.bean.PersistBean;

public class SolrCloudUtil {
  static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private final String zkHost = "10.202.202.101:2181,10.202.202.102:2181,10.202.202.103:2181";
  private SolrClient client =  null;
  
  private final String baseSolrUrl = "http://10.202.202.101:8983/solr/m_station_solr";
  
  public void solrCloudQuery(){
    client = new CloudSolrClient(zkHost);
    SolrQuery param = new SolrQuery("*:*");
    param.add("shard", "shard1");
    try {
      QueryResponse response = client.query("m_station_solr",param);
      log.info("hello.{}",1);
      log.info("result:{}",response.getResults().getNumFound());
    } catch (SolrServerException | IOException e) {
      log.info("exceptin:",e);
    }finally{
      try {
        client.close();
      } catch (IOException e) {
        log.info("exceptin:",e);
      }
    }
  }
  
  public void updateSolrDocument() throws Exception{
    ConcurrentUpdateSolrClient upClient = new ConcurrentUpdateSolrClient(baseSolrUrl, 100, 2);
    SolrInputDocument doc = new SolrInputDocument();
    String docId = "my_test2";
    doc.setField("id", 1); 
    doc.setField("name", docId);    
    UpdateRequest req = new UpdateRequest();
    req.add(doc);   
    req.setAction(ACTION.COMMIT, false, false, true);
    NamedList<Object> params = upClient.request(req);
    upClient.blockUntilFinished();
    upClient.shutdownNow();
    log.info(params.toString());
  }
  
  public void batchUpdateDocument() throws Exception{
    ConcurrentUpdateSolrClient upClient = new ConcurrentUpdateSolrClient(baseSolrUrl, 100, 2);
    upClient.setPollQueueTime(0);
    upClient.blockUntilFinished();
    int poolSize = 5;
    ExecutorService threadPool = ExecutorUtil.newMDCAwareFixedThreadPool(poolSize, new SolrjNamedThreadFactory("batchUpdate"));
    int numDocs = 100;
    int numRunnables = 5;
    for (int r=0; r < numRunnables; r++)
      threadPool.execute(new SendDocsRunnable(String.valueOf(r), numDocs, upClient));
    // ensure all docs are sent
    threadPool.awaitTermination(5, TimeUnit.SECONDS);
    threadPool.shutdown();
    upClient.blockUntilFinished();
    upClient.shutdownNow();
    
  }
  
  public void deleteSolr() throws Exception{
    try(CloudSolrClient client = new CloudSolrClient(zkHost,true);){
      UpdateResponse result = client.deleteByQuery("m_station_solr","*:*", 1000);
      log.info(result.getRequestUrl());
    }
  }
  
  public void updateSolrByBean() throws Exception{
    try(ConcurrentUpdateSolrClient upClient = new ConcurrentUpdateSolrClient(baseSolrUrl, 50, 2);){
      upClient.setPollQueueTime(0);
      upClient.blockUntilFinished();
      List<PersistBean> docItems = new ArrayList<>(2);
      PersistBean p = new PersistBean();
      p.setId("L_1");
      p.setName("LG_test");
      p.setCat(Arrays.asList("lg_1","lg_2"));
      docItems.add(p);
      p = new PersistBean();
      p.setId("L_2");
      p.setName("LG_test_3");
      p.setCat(Arrays.asList("lg_1","lg_2"));
      docItems.add(p);
      UpdateResponse result = upClient.addBeans(docItems);
      upClient.blockUntilFinished();
      log.info("response status:"+result.getStatus());
    }
  }
  
  public void fullImport() throws Exception{
    String url = baseSolrUrl + "/dataimport";
    Map<String,String> param = new HashMap<String, String>();
    param.put("command", "full-import");
    param.put("clean", "true");
    param.put("commit", "true");
    String reslut = HttpUtil.doPost(url, param);
    log.info("----"+reslut);
    
  }
  
  public static void main(String[] args) throws Exception{
    SolrCloudUtil util = new SolrCloudUtil();
//    util.solrCloudQuery();
//    util.updateSolrDocument();
//    util.batchUpdateDocument();
//    util.deleteSolr();
//    util.updateSolrByBean();
    util.fullImport();
  }
      
  class SendDocsRunnable implements Runnable {
    
    private String id;
    private int numDocs;
    private ConcurrentUpdateSolrClient cuss;
    private PersistBean p;
    SendDocsRunnable(String id, int numDocs, ConcurrentUpdateSolrClient cuss) {
      this.id = id;
      this.numDocs = numDocs;
      this.cuss = cuss;
    }

    @Override
    public void run() {
      for (int d=0; d < numDocs; d++) {
//        SolrInputDocument doc = new SolrInputDocument();
        String docId = id+"_"+d;
//        doc.setField("id", docId);
        p = new PersistBean();
        p.setId(docId);
        p.setName("lg_test_"+id);
        p.setCat(Arrays.asList("lg_1","lg_2"));
        
        UpdateRequest req = new UpdateRequest();
//        req.setAction(ACTION.COMMIT, false, false, true);
        req.add(cuss.getBinder().toSolrInputDocument(p));    
        try {
          cuss.request(req);
          log.info("sent document >>>>>>>>>> " + docId);
        } catch (Throwable t) {
          t.printStackTrace();
        }
      }      
    }    
  }
}
