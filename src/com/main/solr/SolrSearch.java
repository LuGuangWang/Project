package com.main.solr;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.main.solr.bean.ResultBean;

public class SolrSearch {
  static Logger log = LoggerFactory.getLogger(SolrSearch.class);
  private static final String solrServer = "http://10.202.80.88:8080/solr/jw/";
  private static HttpSolrServer server = new HttpSolrServer(solrServer);
  
  static void testSearchQ(){
    SolrQuery query = new SolrQuery();
    query.setQuery("name:\"新东方总部大厦504教室(旧)\"");
//    query.setFilterQueries("name:\"高峰\"");
    query.add("wt", "json");
    query.setFields("name","address_s");
    try {
      QueryResponse resp = server.query(query);
      List<ResultBean> results = resp.getBeans(ResultBean.class);
      log.info("result:{}",results);
    } catch (SolrServerException e) {
    }
  }
  
  
  static void testMergeIndex(){
    SolrInputDocument doc = new SolrInputDocument();
    doc.addField("name", "LGTEST");
    doc.addField("id_no", "19891229");
    doc.addField("id", "19891229");
    try{
      server.add(doc);
      server.optimize(true,true);
      server.commit();
    }catch(Exception e){
      log.info("exception:",e);
    }
  }
  
  
  public static void main(String[] args){
//    testMergeIndex();
    testSearchQ();
  }
}
