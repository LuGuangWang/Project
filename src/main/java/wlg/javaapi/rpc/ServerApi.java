package wlg.javaapi.rpc;

import java.io.IOException;

import javassist.tools.web.Webserver;


public class ServerApi {
  
  private static final String port = "8005";
  
  public static void main(String[] args) {
    try {
      Webserver server = new Webserver(port);
      server.run();
    } catch (IOException e) {
    }
    
  }
}
