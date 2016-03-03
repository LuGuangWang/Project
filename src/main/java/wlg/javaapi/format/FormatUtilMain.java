/**
 * 
 */
package wlg.javaapi.format;

import java.security.MessageDigest;

/**
 * @author Administrator
 *
 */
public class FormatUtilMain {

	/**
	 * 
	 */
	public FormatUtilMain() {
		// TODO Auto-generated constructor stub
	}

	/** 将一个字节转化成十六进制形式的字符串 */
	private static String byteToHexString(byte b) {
	    String[] hexDigits =
	        {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	    int n = b;
	    if (n < 0)
	      n = 256 + n;
	    int d1 = n / 16;
	    int d2 = n % 16;
	    return hexDigits[d1] + hexDigits[d2];
	}

	/** 对字符串进行MD5加密 */
	public static String encodeByMD5(String originString) {
	    if (originString != null) {
	      try {
	        // 创建具有指定算法名称的信息摘要
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
	        byte[] results = md.digest(originString.getBytes());
	        // 将得到的字节数组变成字符串返回
	        return results.toString().toUpperCase();
	      } catch (Exception ex) {
	        ex.printStackTrace();
	      }
	    }
	    return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte b = 13;
		System.out.println(FormatUtilMain.byteToHexString(b));
		
		System.out.println(FormatUtilMain.encodeByMD5("hello"));
	}

}
