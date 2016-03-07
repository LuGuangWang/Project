package wlg.javaapi.solr.demo.translator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolrTranslatorRule {
  private String[] fields;//应用的字段
  private String sRuleType;// 直接连接规则 如 TO 
  private String solrField;
  private String fieldType;
  
  public SolrTranslatorRule(final String[] fields){
    List<String> tmp = new ArrayList<String>(Arrays.asList(fields));
    this.sRuleType = tmp.get(0);
    tmp.remove(0);
    this.solrField = tmp.get(0);
    tmp.remove(0);
    if(tmp.get(tmp.size()-1).contains("=")){
      this.fieldType = tmp.get(tmp.size()-1).replaceFirst("=", "");
      tmp.remove(tmp.size()-1);
    }
    this.fields = tmp.toArray(new String[fields.length-3]);
  }
  
  public String getFieldType() {
    return fieldType;
  }
  public String getSolrField() {
    return solrField;
  }
  public String[] getFields() {
    return fields;
  }
  public String getsRuleType() {
    return sRuleType;
  }
}
