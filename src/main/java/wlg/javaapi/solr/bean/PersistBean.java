package wlg.javaapi.solr.bean;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class PersistBean {
  @Field
  public String id;
  @Field
  public String name;
  @Field
  public List<String> cat;
  
  public List<String> getCat() {
    return cat;
  }
  public void setCat(List<String> cat) {
    this.cat = cat;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
