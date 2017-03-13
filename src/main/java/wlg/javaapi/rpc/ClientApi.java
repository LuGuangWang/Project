package wlg.javaapi.rpc;

import java.io.InputStream;

public class ClientApi {

  public static void main(String[] args) {
    InputStream in = ClientApi.class.getClass().getResourceAsStream("/wlg/javaapi/rpc/RPCTest.class");
    System.out.println(in==null);
  }
}
