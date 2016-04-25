package wlg.javaapi.solr;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolrCloudUtil {
  static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private final String zkHost = "10.202.202.101:2181,10.202.202.102:2181,10.202.202.103:2181";
  private SolrClient client =  null;
  
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
  
  public void updateSolrDocument(){
    client = new CloudSolrClient(zkHost);
  }
  
  public static void main(String[] args){
    SolrCloudUtil util = new SolrCloudUtil();
    util.solrCloudQuery();
  }
      
}
