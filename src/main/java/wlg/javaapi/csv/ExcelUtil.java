package wlg.javaapi.csv;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class ExcelUtil {
  
  static Logger log = LoggerFactory.getLogger(ExcelUtil.class);
  
  public static Workbook open(InputStream input) throws Exception {
    return WorkbookFactory.create(input);
  }

  public static void setBorder(CellStyle cs) {
    cs.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
    cs.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
    cs.setBorderTop(CellStyle.BORDER_THIN);// 上边框
    cs.setBorderRight(CellStyle.BORDER_THIN);// 右边框
  }
  /**
   * 无权限
   */
  public static CellStyle getNOAuthCellStyle(Workbook wb){
    return createCellStyle(wb,IndexedColors.YELLOW.getIndex());
  }
  /**
   * 导出表头格式
   */
  public static CellStyle headStyle(Workbook wb){
    short border = 1;
    CellStyle style = createCellStyle(wb,IndexedColors.YELLOW.getIndex());
    style.setBorderLeft(border);
    style.setBorderRight(border);
    return style;
  }

  private static CellStyle createCellStyle(Workbook wb,short styleIndex) {
    CellStyle style = wb.createCellStyle();
    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
    style.setFillBackgroundColor(styleIndex);
    style.setFillForegroundColor(styleIndex);
    return style;
  }
  
  public static CellStyle getWarnCellStyle(Workbook wb){
    return createCellStyle(wb,IndexedColors.RED.getIndex());
  }
  
  /**
   * methodName 首字母会自动转大写并加get  (code -> getCode)
   */
  public static <T> Object invokeGetMethod(final Class<?> clazz, String methodName,
      final T instance) {
    if (Strings.isNullOrEmpty(methodName) || instance == null)
      return null;
    Method mothod = null;
    Object obj = null;
    methodName = buildGetMethodName(methodName);
    try {
      mothod = clazz.getMethod(methodName);
      obj = mothod.invoke(instance);
    } catch (Exception e) { // ignore exception
      log.warn(methodName + " method is not exists.");
    }
    return obj;
  }

  private static String buildGetMethodName(String methodName) {
    String firstLetter = String.valueOf(methodName.charAt(0)).toUpperCase();
    if(methodName.length()>1){
      methodName = methodName.substring(1);
    }else{
      methodName = "";
    }
    methodName = "get" + firstLetter + methodName;
    return methodName;
  }
  
}
