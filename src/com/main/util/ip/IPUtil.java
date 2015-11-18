package com.main.util.ip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IPUtil {
  /**
   * 判断当前操作是否Windows.
   *
   * @return true---是Windows操作系统
   */
  public static boolean isWindowsOS() {
    boolean isWindowsOS = false;
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().indexOf("windows") > -1) {
      isWindowsOS = true;
    }
    return isWindowsOS;
  }

  /**
   * 获取本机IP地址，并自动区分Windows还是Linux操作系统
   * 
   * @return String
   */
  public static String getLocalIP() {
    String sIP = "";
    InetAddress ip = null;
    try {
//      // 如果是Windows操作系统
//      if (isWindowsOS()) {
//        ip = InetAddress.getLocalHost();
//      }
      // 如果是Linux操作系统
//      else {
        Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
        while (netInterfaces.hasMoreElements()) {
          NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
          // ----------特定情况，可以考虑用ni.getName判断 // 遍历所有ip
          Enumeration<InetAddress> ips = ni.getInetAddresses();
          while (ips.hasMoreElements()) {
            ip = (InetAddress) ips.nextElement();
            if(ip instanceof Inet4Address && !ip.getHostAddress().contains(":")
                && !ip.getHostAddress().startsWith("127."))
              return ip.getHostAddress();
          }
        }
//      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (null != ip) {
      sIP = ip.getHostAddress();
    }
    return sIP;
  }


  public static void main(String[] args) {
    System.out.println(getLocalIP());
  }

}
