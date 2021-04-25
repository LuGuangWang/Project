package wlg.javaapi.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class WordToImage {
	
	static void wordToImg() {
		String text = "近邻相助";
		int width=100,height=50;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();
		//透明
//		img = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
//		g2d = img.createGraphics();

//		Font font = new Font("宋体",Font.PLAIN,14);
//		g2d.setFont(font);
//
//		FontMetrics fm = g2d.getFontMetrics();
//		fm.stringWidth(text);
//		fm.getHeight();
//		fm.
//
//		g2d.setColor(Color.GRAY);
		g2d.setFont(g2d.getFont());
		g2d.setColor(Color.gray);
		g2d.drawString(text, 20,30);
		
		g2d.dispose();
		
		try {
			ImageIO.write(img, "png", new File("/Users/didi/Desktop/test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		wordToImg();
	}
	
	
}
