package wlg.javaapi.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 文字转图片
 * @author seven
 *
 */
public class WordToImgTest {

	static void wordToImg() {
		try {
			BufferedImage image = ImageIO.read(new File("/home/seven/Desktop/12.jpg"));
		
			Graphics g = image.getGraphics();
			g.setFont(g.getFont().deriveFont(30f));
			
			g.drawString("美丽风景图", 100, 100);
			g.dispose();
			
			ImageIO.write(image, "jpg", new File("/home/seven/Desktop/test.jpg"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		wordToImg();
	}
}
