package wlg.javaapi.solr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wlg.apiutil.httputil.HttpUtil;
import wlg.javaapi.solr.bean.ResultBean;

public class SolrUtil {
  static Logger log = LoggerFactory.getLogger(SolrUtil.class);
  private static final String solrServer = "http://10.202.80.88:8080/solr/jw/";
  private static HttpSolrServer server = new HttpSolrServer(solrServer);
  
  static void testSearchQ(){
    SolrQuery query = new SolrQuery();
//    String localParams = "{!q.op=AND wt=json}";
//    String field1 = "name:教室";
//    String field2 = " area_name:\"*\" NOT \"临时教室校区\"";//不包含
//    String field3 = " -area_name:临时教室校区";//不包含
//    String field4 = " (area_name:临时 OR area_name:新东方总部)";
    String field5 = "name:教室  AND (code:RMBJ03001,RMBJ01009)";//多查询
//    String q =  localParams + field1 +field4;
    String q =  field5;
    query.setQuery(q);
    try {
      QueryResponse resp = server.query(query);
      log.info("ResponseHeader:{}",resp.getResponseHeader());
      List<ResultBean> results = resp.getBeans(ResultBean.class);
      log.info("result:{}",results);
    } catch (Exception e) {
      log.info("exception:",e);
    }
  }
  /**
   * 添加
   */
  static void testMergeIndex(){
   
    long start = System.currentTimeMillis();
    SolrInputDocument doc = new SolrInputDocument();
    doc.addField("name", "LGTEST2");
    doc.addField("id", "19891232");
    SolrInputDocument doc1 = new SolrInputDocument();
    doc1.addField("name", "LGTEST3");
    doc1.addField("id", "19891231");
    List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
    docs.add(doc);
    docs.add(doc1);
    try{
      server.add(docs);
      server.commit();
    }catch(Exception e){
      log.info("exception:",e);
    }
    
    long end =  System.currentTimeMillis();
    System.out.println("taken time:" + (end - start));
  }
  
  /**
   * 测试批量增加
   * @throws Exception 
   * @throws  
   */
  static void testDeltaImport(){
    String url = solrServer + "dataimport";
    Map<String,String> param = new HashMap<String, String>();
    param.put("command", "delta-import");
    param.put("clean", "false");
    param.put("commit", "true");
    param.put("entity", "bs_class");
    String reslut = HttpUtil.doPost(url, param);
    log.info("----"+reslut);
  }
  
  /**
   * 测试全量增加
   * @throws Exception 
   * @throws  
   */
  static void testFullImport(){
    String url = solrServer + "dataimport";
    Map<String,String> param = new HashMap<String, String>();
    param.put("command", "full-import");
    param.put("clean", "true");
    param.put("commit", "true");
    param.put("entity", "bs_room");
    HttpUtil.doPost(url, param);
  }
  
  static void testDelete(){
    try{
      server.deleteById("19891230");
      server.commit();
    }catch(Exception e){
      log.error("exception:",e);
    }
  }
  
  public static void main(String[] args){
    testMergeIndex();
//    testSearchQ();
//    testDeltaImport();
//    testFullImport();
//    testDelete();
  }
}
