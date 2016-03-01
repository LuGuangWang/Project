package com.main.solr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.main.http.HttpUtil;
import com.main.solr.bean.ResultBean;

public class SolrSearch {
  static Logger log = LoggerFactory.getLogger(SolrSearch.class);
  private static final String solrServer = "http://10.202.80.88:8080/solr/jw/";
  private static HttpSolrServer server = new HttpSolrServer(solrServer);
  
  static void testSearchQ(){
    SolrQuery query = new SolrQuery();
    String localParams = "{!q.op=AND wt=json}";
    String field1 = "name:\"大厦\"";
//    String field2 = " area_name:\"*\" NOT \"临时教室校区\"";//不包含
//    String field2 = " -area_name:临时教室校区";//不包含
    
    
    String field2 = " (area_name:临时 OR area_name:新东方总部)";
    String q = localParams + field1 +field2;
    query.setQuery(q);
    try {
      QueryResponse resp = server.query(query);
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
    SolrInputDocument doc = new SolrInputDocument();
    doc.addField("name", "LGTEST2");
    doc.addField("id", "19891230");
    try{
      server.add(doc);
      server.optimize(false,false);
      server.commit();
    }catch(Exception e){
      log.info("exception:",e);
    }
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
    String reslut = HttpUtil.doPost(url, param);
    log.info("----"+reslut);
  }
  public static void main(String[] args){
//    testMergeIndex();
//    testSearchQ();
//    testDeltaImport();
    testFullImport();
  }
}
