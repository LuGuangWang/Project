package wlg.javaapi.solr.bean;

import org.apache.solr.client.solrj.beans.Field;

import wlg.apiutil.jsonutil.Util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBean {
  @Field
  private String name;
  @Field
  private String area_name;
  @Field
  private String school_name;
  @Field
  private String business_name;

  public String getArea_name() {
    return area_name;
  }

  public void setArea_name(String area_name) {
    this.area_name = area_name;
  }

  public String getSchool_name() {
    return school_name;
  }

  public void setSchool_name(String school_name) {
    this.school_name = school_name;
  }

  public String getBusiness_name() {
    return business_name;
  }

  public void setBusiness_name(String business_name) {
    this.business_name = business_name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String toString(){
    return Util.toJson(this);
  }
}
