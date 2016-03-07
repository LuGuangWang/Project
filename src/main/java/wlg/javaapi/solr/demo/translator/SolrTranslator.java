package wlg.javaapi.solr.demo.translator;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import wlg.apiutil.Util;

import com.google.common.base.Strings;

@Service
public class SolrTranslator{
  protected Logger log = LoggerFactory.getLogger(getClass());
  
  /**
   * specialFields key : rule+searchField+field1+field2+..
   */
  public <T> String buildSQLCondition(T searchIn,List<String> specialFields){
    StringBuffer con = new StringBuffer();
    final String OPERATE_AND = " AND ",METHOD_PREFIX = "get";
    Map<String,SolrTranslatorRule> sFieldMap = parseSpecialFields(specialFields,METHOD_PREFIX);
    
    Method[] methods = searchIn.getClass().getMethods();
    for(Method m:methods){
      if(m.getName().startsWith(METHOD_PREFIX) && !"getClass".equals(m.getName())){
        if(sFieldMap.containsKey(m.getName())){
          specialBuildSql(searchIn, con, OPERATE_AND, METHOD_PREFIX, sFieldMap, m);
        }else{
          normalBuildSql(METHOD_PREFIX,searchIn, OPERATE_AND, con, m);
        }
      }
    }
    removeLastOperator(con, OPERATE_AND);
    log.debug("solr SQL:{}" , con);
    return con.toString();
  }

  private <T> void specialBuildSql(T searchIn, StringBuffer con, final String operator,
      final String M_PREFIX, Map<String, SolrTranslatorRule> sFieldMap, Method m) {
    SolrTranslatorRule rule = sFieldMap.get(m.getName());
    if(rule != null){
      StringBuffer fieldValue = buildSpecialFieldValue(searchIn, M_PREFIX, rule); 
      if(fieldValue.length()>0){
        appendFieldName(con, rule.getSolrField());
        con.append(fieldValue);
        con.append(operator);
      }
    }
  }

  private <T> StringBuffer buildSpecialFieldValue(T searchIn, final String M_PREFIX, SolrTranslatorRule rule) {
    StringBuffer con = new StringBuffer();
    boolean flag = false;
    appendSymbol(rule, con,true);
    if(Strings.isNullOrEmpty(rule.getsRuleType())){
      for(String field:rule.getFields()){
        try {
          Method fieldMethod = searchIn.getClass().getMethod(M_PREFIX + upperFirstLetter(field));
          Object obj = fieldMethod.invoke(searchIn);
          if(obj != null){
            con.append(appendFieldValue(obj,rule));
          }
        } catch (Exception e) {
          log.error("build solr query error :",e);
          throw new RuntimeException("build solr query error.");
        }
      }
    }else
      appendSpecialFieldValueByRuleType(searchIn, M_PREFIX, rule, con, flag);
    return con;
  }

  private <T> void appendSpecialFieldValueByRuleType(T searchIn, final String M_PREFIX,
      SolrTranslatorRule rule, StringBuffer con, boolean flag) {
    String operator = " " + rule.getsRuleType().toUpperCase() + " ";
    for(String field:rule.getFields()){
      try {
        Method fieldMethod = searchIn.getClass().getMethod(M_PREFIX + upperFirstLetter(field));
        Object obj = fieldMethod.invoke(searchIn);
        if(obj != null){
          con.append(appendFieldValue(obj,rule));
          flag = true;
        }else{
          appendFlag(rule, con);
        }
        con.append(operator);
      } catch (Exception e) {
        log.error("build solr query error :",e);
        throw new RuntimeException("build solr query error.");
      }
    }
    if(flag){
      removeLastOperator(con, operator);
      appendSymbol(rule, con,false);
    }else{
      con.delete(0, con.length());
    }
  }

  private void appendFlag(SolrTranslatorRule rule, StringBuffer con) {
    if("to".equalsIgnoreCase(rule.getsRuleType())){
      con.append("*");
    }
  }

  private void appendSymbol(SolrTranslatorRule rule, StringBuffer con,boolean isFirst) {
    if("to".equalsIgnoreCase(rule.getsRuleType())){
      if(isFirst){
        con.append("[");
      }else
        con.append("]");
    }
  }

  private void removeLastOperator(StringBuffer con, final String operator) {
    if(con.length()>0)
      con.delete(con.length()-operator.length(), con.length());
  }

  private Map<String,SolrTranslatorRule> parseSpecialFields(List<String> specialFields,String M_PREFIX) {
    Map<String,SolrTranslatorRule> sFieldMap = null;
    String fieldMethod = null;
    if(specialFields!=null){
      sFieldMap = new HashMap<>(specialFields.size());
      for(String sField:specialFields){
        String[] fieldArr = sField.split("\\+");
        if(fieldArr.length<3)
          throw new RuntimeException("set solr special fields error.");
        SolrTranslatorRule r = new SolrTranslatorRule(fieldArr);
        for(int i=2;i<fieldArr.length;i++){
          fieldMethod = M_PREFIX + upperFirstLetter(fieldArr[i]);
          if(i==2)
            sFieldMap.put(fieldMethod, r);
          else
            sFieldMap.put(fieldMethod, null);
        }
      }
    }
    return sFieldMap;
  }

  private <T> void normalBuildSql(final String M_PREFIX,T searchIn, final String operate, StringBuffer con, Method m) {
      try{
        Object obj = m.invoke(searchIn);
        if(obj==null)
          return;
        StringBuffer fieldValue = appendFieldValue(obj,null);
        if(fieldValue.length()>0){
          appendFieldName(M_PREFIX, con, m);
          con.append(fieldValue);
          con.append(operate);
        }
      }catch(Exception e){
        log.error("build solr query error :",e);
        throw new RuntimeException("build solr query error.");
      }
  }

  private StringBuffer appendFieldValue(Object obj,SolrTranslatorRule rule) {
    StringBuffer con  = new StringBuffer();
    if(rule==null || Strings.isNullOrEmpty(rule.getFieldType())){
      if(obj instanceof Integer || obj instanceof Boolean || obj instanceof Double){
        con.append(obj);
      }else if(obj instanceof List){
        appendListFieldValue(con, obj);
      }else{
        con.append("\"").append(obj).append("\"");
      }
    }else{
      if("date".equalsIgnoreCase(rule.getFieldType())){//2011-06-14T08:41:59Z
        try {
          con.append(Util.toUTC(obj.toString()));
        } catch (ParseException e) {
          log.error("solr parse date error.",e);
          throw new RuntimeException("solr parse date error.");
        }
      }
    }
    return con;
  }

  private void appendListFieldValue(StringBuffer con, Object obj) {
    final String OPERATE_OR = " OR ";
    List<?> oList = (List<?>) obj;
    con.append("(");
    if(oList.size()>1){
      Iterator<?> it = ((List<?>) obj).iterator();
      while(it.hasNext()){
        con.append(it.next()).append(OPERATE_OR);
      }
      removeLastOperator(con, OPERATE_OR);
    }else{
      con.append(oList.get(0));
    }
    con.append(")");
  }
  
  private void appendFieldName(final String M_PREFIX, StringBuffer con, Method m) {
    String fieldName = m.getName().replaceFirst(M_PREFIX, "");
    if(m.getReturnType()!=null && m.getReturnType().equals(List.class))
      con.append(lowerFirstLetter(fieldName+"_ss"));
    else
      con.append(lowerFirstLetter(fieldName));
    con.append(":");
  }

  private void appendFieldName(StringBuffer con, String fieldName) {
    con.append(fieldName).append(":");
  }
  
  private String upperFirstLetter(String str){
    if(str.length()>1)
      str = String.valueOf(str.charAt(0)).toUpperCase().concat(str.substring(1));
    else
      str = str.toUpperCase(); 
    return str;
  }
  
  private String lowerFirstLetter(String str){
    if(str.length()>1)
      str = String.valueOf(str.charAt(0)).toLowerCase().concat(str.substring(1));
    else
      str = str.toLowerCase(); 
    return str;
  }
}
