package wlg.javaapi.image;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageToBase64 {
	/**
	 * @Description: 将base64编码字符串转换为图片
	 * @Author:
	 * @CreateTime:
	 * @param imgStr
	 *            base64编码字符串
	 * @param path
	 *            图片路径-具体到文件
	 * @return
	 */
	public static boolean generateImage(String imgStr, String path) {
		if (imgStr == null)
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// 解密
			byte[] b = decoder.decodeBuffer(imgStr);
			// 处理数据
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @Description: 根据图片地址转换为base64编码字符串
	 * @Author: 
	 * @CreateTime: 
	 * @return
	 */
	public static String getImageStr(String imgFile) {
	    byte[] data = null;
	    try (InputStream inputStream = new FileInputStream(imgFile)){
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	        inputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // 加密
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);
	}
	
	/**
	 * 示例
	 */
	public static void main(String[] args) {
//	    String strImg = getImageStr("/home/seven/Desktop/test.png");
//	    System.out.println(strImg);
	    String strImg = "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k/uY49u7G77ijOdq9fSufoA7/wDaa/5lb/t7/wDaNeAV0Hifxt4i8Y/Zf7f1D7Z9l3+T+5jj27sbvuKM52r19K5+iiiigAooooooooAKKKKKKKKACiiiiiiigDoLP/knms/9hWw/9FXdc/XQWf8AyTzWf+wrYf8Aoq7rn6KKKKACiiiiiiigAooooooooAKKKKKKKKAOg8d/8lD8S/8AYVuv/RrVz9dB47/5KH4l/wCwrdf+jWrn6KKKKACiiiiiiigAooooooooAKKKKKKKKACiiiiiiigAooooooooAKKKKKKKKACiiiiiiigAooooooooAKKKKKKKKACiiiiiiigAooooooooAKKKKKKKKACiiiiiiigAooooooooA2NDvreODUNMvZPLtdQiVBMyl0t5VdWSUqOTgB0JHzBZXIDfdavqeh6po3lHUbCe3jmyYJmT93OBjLRuPlkXkHcpIIIIOCKz60NM13WNE83+ydVvrDzseZ9kuHi34zjO0jOMnr6miiiigDPoroP+E78Yf9DXrn/gxm/+Ko/4Tvxh/wBDXrn/AIMZv/iqKKKKAOforoP+E78Yf9DXrn/gxm/+Ko/4Tvxh/wBDXrn/AIMZv/iqKKKKAOfrpNJ0mbRbix17XtPki02N47mGC6hI/tHBDCOMMMMjDG5+VVT3JRHj/wCE78Yf9DXrn/gxm/8Aiqw555rq4luLiWSaeVy8kkjFmdickknkknnNFFFFABPPNdXEtxcSyTTyuXkkkYszsTkkk8kk85qOiiiiiigAooooooooAKKKKKKKKACiiiiiiigAooooooooAKKKKKKKKACiiiiiiigAooooooooAKKKKKKKKACiiiiiiigAooooooooAKKKKKKKKACiiiiiiigAooor/9k=";
	    generateImage(strImg, "/home/seven/Desktop/test1.jpg");
	}
}
