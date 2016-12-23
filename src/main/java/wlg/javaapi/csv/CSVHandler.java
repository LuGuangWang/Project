package wlg.javaapi.csv;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVHandler {
  private Logger log = LoggerFactory.getLogger(CSVHandler.class);
  private String[] headerCodes = null;
  private CSVPrinter printer = null;
  private FiledParser fieldParser;
  private List<ResultBean> headerColumns;
  private String filePath;
  /**
   * @param fieldParser 解析字段，must not null.
   * @param headerColumns 表头字段，can be null.
   * @param filePath 文件的绝对路径
   */
  public CSVHandler(FiledParser fieldParser, List<ResultBean> headerColumns,String fileName) {
    this.fieldParser = fieldParser;
    this.headerColumns = headerColumns;
    this.filePath = fileName;
  }

  public <T> void export(List<T> rows) throws Exception {
    String filedCode;
    Object[] values;
    printer = createCSVPrinter(headerColumns);
    if (rows != null && rows.size() > 0) {
      for (int i = rows.size() - 1; i >= 0; i--) {
        values = new Object[headerCodes.length];
        T obj = rows.remove(i);
        for (int m = headerCodes.length - 1; m >= 0; m--) {
          filedCode = headerCodes[m];
          values[m] = getFieldValue(obj, filedCode);
        }
        printer.printRecord(values);
      }
    }
  }

  private <T> Object getFieldValue(T data, String fieldCode) {
    return String.valueOf(fieldParser.getFieldValue(data, fieldCode));
  }

  /**
   * 获取表头
   * 
   * @param headerColumns code,name must not null.
   */
  private String[] getHeaderColumns(List<ResultBean> headerColumns) {
    String columnName = null,columnCode = null;
    Set<String> headNames = null,headCodes = null;
    ResultBean rBean = null;
    String[] result = null;
    try {
      if (headerColumns != null) {
        headNames = new LinkedHashSet<>(headerColumns.size());
        headCodes = new LinkedHashSet<>(headerColumns.size());
        // 排序
        if (headerColumns.size() > 1) {
          Collections.sort(headerColumns, (a, b) -> {
            if (a.getFieldOrder() == null) {
              return 1;
            } else if (b.getFieldOrder() == null) {
              return 1;
            } else {
              return a.getFieldOrder() - b.getFieldOrder();
            }
          });
        }
        // 赋值
        for (int i = 0; i <headerColumns.size(); ) {
          rBean = headerColumns.remove(i);
          columnCode = rBean.getCode() == null ? "" : rBean.getCode();
          //TODO 改回
//          columnName = rBean.getName() == null ? "" : rBean.getName();
          columnName = rBean.getName() == null ? columnCode : rBean.getName();
          if (!headNames.contains(columnName)) {// 去重
            headCodes.add(columnCode);
            headNames.add(columnName);
          }
        }
        headerCodes = headCodes.toArray(new String[headCodes.size()]);
        result = headNames.toArray(new String[headNames.size()]);
      }
      return result;
    } finally {
      if(headCodes!=null){
        headCodes.clear();
        headCodes = null;
      }
      if(headNames!=null){
        headNames.clear();
        headNames = null;
      }
    }
  }

  private CSVPrinter createCSVPrinter(List<ResultBean> headerColumns) throws Exception {
    if (printer == null) {
      synchronized (CSVPrinter.class) {
        if (printer == null) {
          String[] header = getHeaderColumns(headerColumns);
          CSVFormat format = null;
          if (header != null) {
            format = CSVFormat.EXCEL.withHeader(header);
          }else{
            format = CSVFormat.EXCEL;
          }
          printer = new CSVPrinter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"GBK")),format);
        }
      }
    }
    return printer;
  }

  public void close() {
    headerCodes = null;
    try {
      if (printer != null) {
        printer.close();
        printer = null;
      }
    } catch (Exception e) {
      log.error("close csv printer error.");
    }
  }
}
