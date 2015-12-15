package com.main.excel.demo;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

/**
 * 导入公共类 模板的规则 对应的英文字段， 模板的第一行为中文名称，第二行为对应bean的英文字段,首字母要大写
 */
@Service
public class ImportHelper {
  private Logger log = LoggerFactory.getLogger("import_log");
  private final int ROW_START = 2;// 表行从第二行开始
  private final int COLUMN_END = 50;// 字段列限制，最长50列
  private FormulaEvaluator formulaEvaluator = null;
  
  /**
   * 解析
   */
  public <T> List<T> pareseExcel(InputStream input, Class<T> clazz) throws Exception {
    try(Workbook workbook = ExcelUtil.open(input)){
      Sheet sheet = workbook.getSheetAt(0);
      if (sheet == null)
        return new ArrayList<T>(1);
      Map<Integer, String> reflect = parseReflect(sheet);// call parse reflect function
      setFormulaEvaluator(workbook);
      return parseExcelRow(sheet, clazz, reflect);
    }
  }
  //set formula evaluator
  private void setFormulaEvaluator(Workbook workbook){
    if(formulaEvaluator==null)
      formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
  }

  /**
   * 解析映射关系
   */
  public Map<Integer, String> parseReflect(Sheet sheet) {
    Row row = sheet.getRow(1);// 模板
    if (row == null)
      throw new RuntimeException("模板不对，请重新下载模板。");
    int lastColumn = Math.min(row.getLastCellNum(), COLUMN_END);
    Map<Integer, String> reflect = new HashMap<Integer, String>(lastColumn);
    for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
      String filedName = row.getCell(columnIndex).getStringCellValue().trim();
      reflect.put(columnIndex, filedName);
    }
    return reflect;
  }

  /**
   * 解析excle的行
   * 
   * @throws Exception
   */
  public <T> List<T> parseExcelRow(Sheet sheet, final Class<T> clazz,
      final Map<Integer, String> reflect) throws Exception{
      int rowStart = Math.max(ROW_START, sheet.getFirstRowNum());
      int rowEnd = sheet.getPhysicalNumberOfRows();
      List<T> resultData = new ArrayList<T>();
      for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
        Row row = sheet.getRow(rowNum);
        if (row == null) // This whole row is empty
          continue;
        // 构建对象
        T instance = null;
        try {
          instance = parseExcelColumn(row, clazz, reflect);
          callChecker(clazz, instance);
          instance = setRowNum(row,clazz, instance);//获取行号
        } catch (Exception e) {
          log.debug("parse excel row exception:",e);//ignore parse exception
        }
        resultData.add(instance);
      }
      return resultData;
  }

  /**
   * 解析excel的列 组装成对象
   * @throws Exception 
   * 
   * @throws Exception
   */
  public <T> T parseExcelColumn(Row row, final Class<T> clazz, final Map<Integer, String> reflect) throws Exception{
    int lastColumn = Math.min(row.getLastCellNum(), COLUMN_END);
    T instance = clazz.newInstance();
    Cell cell = null;
    StringBuffer errorMsg = new StringBuffer();
    for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
      try {
        cell = row.getCell(columnIndex, Row.RETURN_BLANK_AS_NULL);
        if (cell == null)
          continue;
        String value = getCellVale(cell);
        instance = buildInstance(clazz, reflect.get(columnIndex), value, instance);
      } catch (Exception e) {
        log.debug("parse excel cell exception:",e);
        errorMsg.append(getCellInfo(cell, reflect.get(columnIndex)));
      }
    }
    if(!Strings.isNullOrEmpty(errorMsg.toString()))
      instance = setErrorMsg(clazz, instance, errorMsg);
    log.debug("excel row instance:" + instance);
    return instance;
  }
  
  private String getCellValue(int cellType,Cell cell){
    String value = null;
    switch (cellType) {
      case Cell.CELL_TYPE_STRING:
        value = cell.getRichStringCellValue().getString();
        break;
      case Cell.CELL_TYPE_NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
          Date date = cell.getDateCellValue();
          value = String.valueOf(date);
        } else {
          value = String.valueOf(cell.getNumericCellValue()).replaceFirst("\\.0+$", "");// 全为00的小数转为整数
        }
        break;
      case Cell.CELL_TYPE_BOOLEAN:
        if (cell.getBooleanCellValue())// true转为1
          value = "1";
        else
          value = "0";
        break;
      case Cell.CELL_TYPE_ERROR:
        throw new RuntimeException("此列值错误："+String.valueOf(cell));// 错误行
      default:
        value = null;
    }
    return value;
  }
  
  /**
   * 取cell 的值
   */
  private String getCellVale(Cell cell) {
    String value = null;
    if(Cell.CELL_TYPE_FORMULA != cell.getCellType()){
      value = getCellValue(cell.getCellType(),cell);
    }else{
      value = getCellValue(formulaEvaluator.evaluateFormulaCell(cell),cell);
    }
    return value;
  }

  // 错误信息
  private String getCellInfo(Cell cell,String fieldName) {
    return fieldName + "列值 " + cell + " 无法解析 ";
  }

  /**
   * 通过对象的set方法，构建对象
   * @throws Exception
   */
  private <T> T buildInstance(final Class<T> clazz, String methodName, String methodParam,
      final T instance) throws Exception {
    if (Strings.isNullOrEmpty(methodName) || instance == null)
      return instance;
    Method mothod = null;
    try {
      methodName = "set" + methodName;
      mothod = clazz.getMethod(methodName, String.class);
      if(methodParam!=null)
        mothod.invoke(instance, methodParam.trim());//去掉空格
    } catch (Exception e) {
      log.debug("call" + methodName + " Exception:{}", e);
      throw e;
    }
    return instance;
  }

  private <T> T setErrorMsg(final Class<T> clazz, T instance,StringBuffer errMsg) throws Exception{
    if (instance == null)
      instance = clazz.newInstance();
    try {
      Method mothod = clazz.getMethod("setErrorMsg", String.class);
      mothod.invoke(instance, errMsg.toString());
    } catch(NoSuchMethodException e){
      log.warn("call setErrorMsg Exception："+ e);
    } catch (Exception e) { // ignore exception
      log.warn("call setErrorMsg Exception："+ e);
      throw e;
    }
    return instance;
  }
  
  private <T> void callChecker(final Class<T> clazz, final T instance) throws Exception{
    if (instance == null)
      return;
    try {
      Method mothod = clazz.getMethod("toCheck");
      mothod.invoke(instance);
    } catch(NoSuchMethodException e){
      log.warn("call checher Exception："+ e );
    } catch (Exception e) { // ignore exception
      log.warn("call checher Exception："+ e);
      throw e;
    }
  }
  
  private <T> T setRowNum(Row row,final Class<T> clazz, final T instance) throws Exception{
    if (instance == null)
      return instance;
    try {
      Method mothod = clazz.getMethod("setRowNum", String.class);
      mothod.invoke(instance, String.valueOf(row.getRowNum()+1));
    } catch (Exception e) { // ignore exception
      log.debug("set rownum Exception:{}", e);
      throw e;
    }
    return instance;
  }
  
}
