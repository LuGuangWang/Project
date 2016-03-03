package wlg.javaapi.excel;

import java.io.OutputStream;
import java.util.List;

/**
 * 提供的excel的方法
 */
public interface ExcelHandler {
  /**
   * 创建excel模板
   * @return
   */
  int createExcelTemplate(OutputStream excelTemplate,String[] headers,String sheetName) throws Exception;
  /**
   * 检查模板的必填项
   */
  void checkTemplate();
  /**
   * 将excel中的数据全转换为string类型，以便与数据库交互
   * @return
   */
  String getCellValue();
  /**
   * 读取模板中的数据，转换为bean
   * @return
   */
  <T> List<T> readTemplate();
}
