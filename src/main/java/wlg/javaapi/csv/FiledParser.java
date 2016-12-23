package wlg.javaapi.csv;

public interface FiledParser {
  /**
   * 默认文字解析
   */
  default <T> Object dparseFieldValue(T data, String fieldCode){
    return ExcelUtil.invokeGetMethod(data.getClass(), fieldCode, data);
  }
  
  public <T> Object getFieldValue(T data, String fieldCode);
}
