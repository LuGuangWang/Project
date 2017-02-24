package wlg.javaapi.serial;

import java.io.Serializable;

public class SerializeObj implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
