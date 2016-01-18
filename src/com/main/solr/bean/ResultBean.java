package com.main.solr.bean;

import main.util.Util;

import org.apache.solr.client.solrj.beans.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBean {
  @Field
  private String name;
  @Field
  private String address_s;
  
  public String getAddress_s() {
    return address_s;
  }

  public void setAddress_s(String address_s) {
    this.address_s = address_s;
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
