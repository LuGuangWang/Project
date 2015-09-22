package com.main.excel.demo;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

/**
 * 导入公共类 模板的规则 对应的英文字段，
 * 模板的第一行为中文名称，第二行为对应bean的英文字段,首字母要大写
 */
@Service
public class ImportHelper {
  private Logger log = LoggerFactory.getLogger(getClass());
  private final int ROW_START = 2;// 表行从第二行开始
  private final int COLUMN_END = 200;// 字段列限制，最长200列
  /**
   * 解析
   */
  public <T> List<T> pareseExcel(InputStream input, Class<T> clazz) throws Exception {
    Workbook workbook = ExcelUtil.open(input);
    Sheet sheet = workbook.getSheetAt(0);
    if (sheet == null)
      return new ArrayList<T>(1);
    Map<Integer, String> reflect = parseReflect(sheet);// call parse reflect function
    return parseExcelRow(sheet, clazz, reflect);
  }

  /**
   * 解析映射关系
   */
  public Map<Integer, String> parseReflect(Sheet sheet) {
    Row row = sheet.getRow(1);//模板
    if(row==null)
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
      final Map<Integer, String> reflect) throws Exception {
    int rowStart = Math.max(ROW_START, sheet.getFirstRowNum());
    int rowEnd = sheet.getLastRowNum();

    List<T> resultData = new ArrayList<T>();

    for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
      Row row = sheet.getRow(rowNum);
      if (row == null) // This whole row is empty
        continue;
      //构建对象
      T instance = parseExcelColumn(row, clazz, reflect);
      //to check before add
      callChecker(clazz, instance);
      // call parse column function
      resultData.add(instance);
    }
    return resultData;
  }

  /**
   * 解析excel的列 组装成对象
   * 
   * @throws Exception
   */
  public <T> T parseExcelColumn(Row row, final Class<T> clazz, final Map<Integer, String> reflect)
      throws Exception {
    int lastColumn = Math.min(row.getLastCellNum(), COLUMN_END);
    T instance = clazz.newInstance();
    for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
      Cell cell = row.getCell(columnIndex, Row.RETURN_BLANK_AS_NULL);
      try {
        if (cell == null) // The spreadsheet is empty in this cell
          continue;
        //调用getCellValue function
        String value = getCellVale(cell);
        // call build Instance function
        instance = buildInstance(clazz, reflect.get(columnIndex), value, instance);
      } catch (Exception e) {
        getCellInfo(cell);
        throw e;
      }
    }
    log.debug("excel row instance:" + instance);
    return instance;
  }

  /**
   * 取cell 的值
   */
  private String getCellVale(Cell cell){
    String value = null;
    switch (cell.getCellType()) {
      case Cell.CELL_TYPE_STRING:
        value = cell.getRichStringCellValue().getString();
        break;
      case Cell.CELL_TYPE_NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
//          Date date = cell.getDateCellValue();
//          value = Util.formatDateTime(date);
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
      case Cell.CELL_TYPE_FORMULA:
        value = cell.getCellFormula();
        break;
      default:
        value = null;
    }
    return value;
  }
  
  // 错误信息
  private String getCellInfo(Cell cell) {
    return "sheet: " + cell.getSheet().getSheetName()
           + ", 行: "
           + (cell.getRowIndex() + 1)
           + ", 列:"
           + (cell.getColumnIndex() + 1)
           + ", 值:"
           + cell.toString();
  }

  /**
   * 通过对象的set方法，构建对象
   * 
   * @throws Exception
   * 
   */
  private <T> T buildInstance(final Class<T> clazz, String methodName, String methodParam,
      final T instance) {
    if (Strings.isNullOrEmpty(methodName) || instance == null)
      return instance;
    Method mothod = null;
    try {
      methodName = "set" + methodName;
      mothod = clazz.getMethod(methodName, String.class);
      mothod.invoke(instance, methodParam);
    } catch (Exception e) { // ignore exception
      log.debug(methodName + " method is not exists. Exception:{}", e);
    }
    return instance;
  }
  
  /**
   * 调用check方法
   * @throws Exception 
   */
  private <T> void callChecker(final Class<T> clazz,final T instance) throws Exception {
    try {
      Method mothod = clazz.getMethod("toCheck");
      mothod.invoke(instance);
    } catch (Exception e) { // ignore exception
      log.debug("toCheck" + " method is not exists. Exception:{}", e);
      throw e;
    }
  }
}
