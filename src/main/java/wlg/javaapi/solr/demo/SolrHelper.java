package wlg.javaapi.solr.demo;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import wlg.javaapi.solr.demo.translator.SolrTranslator;

abstract public class SolrHelper {
  private Logger log = LoggerFactory.getLogger(getClass());
  
  private static final String solrServer = "http://10.202.80.88:8080/solr/jw/";
  @Autowired
  SolrTranslator t;
  
  abstract protected List<String> buildSepcialFields();
  
  public <T,E> List<E> solrQuery(T searchIn,Class<E> type,Integer no,Integer size){
    List<E> result = null;
    SolrClient server = null;
    try {
      server = new HttpSolrClient(solrServer);
      SolrQuery query = new SolrQuery();
      query.setStart((no - 1) * size);
      query.setRows(size);
      query.setQuery(t.buildSQLCondition(searchIn,this.buildSepcialFields()));
      QueryResponse resp = server.query(query);
      result = resp.getBeans(type);
      log.debug("total count:"+resp.getResults().getNumFound());
    }catch (Exception e) {
      log.error("solr query error:",e);
    }finally{
      if(server!=null)
        try {
          server.close();
        } catch (IOException e) {
        }
    }
    return result;
  }
}
