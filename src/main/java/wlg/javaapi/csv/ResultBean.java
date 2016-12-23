package wlg.javaapi.csv;

public class ResultBean {
  protected String code;
  protected String name;
  protected Float columnWidth;
  private Integer fieldOrder;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Float getColumnWidth() {
    return columnWidth;
  }
  public void setColumnWidth(Float columnWidth) {
    this.columnWidth = columnWidth;
  }
  public Integer getFieldOrder() {
    return fieldOrder;
  }
  public void setFieldOrder(Integer fieldOrder) {
    this.fieldOrder = fieldOrder;
  }
}
