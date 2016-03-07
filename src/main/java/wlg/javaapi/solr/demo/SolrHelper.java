package wlg.javaapi.solr.demo;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wlg.javaapi.solr.SolrUtil;

public class SolrHelper {
  static Logger log = LoggerFactory.getLogger(SolrUtil.class);
  private static final String solrServer = "http://10.202.80.88:8080/solr/jw/";
  private static HttpSolrServer server = new HttpSolrServer(solrServer);
}
