package wlg.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class NewTest {
  public static void main(String[] args) {
	String imgPath = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539949381756&di=45b7e799d5a0317d5a9463ec99eac3b1&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0125fd5770dfa50000018c1b486f15.jpg%401280w_1l_2o_100sh.jpg";
	try {
		URL url = new URL(imgPath);
		BufferedImage image = ImageIO.read(url);
		ImageIO.write(image, "jpg", new File("/home/seven/Desktop/down.jpg"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
