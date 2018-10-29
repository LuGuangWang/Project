package wlg.javaapi.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class WordToImage {
	
	static void wordToImg() {
		String text = "Hello";
		
		BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = img.createGraphics();
		Font font = new Font("Arial",Font.PLAIN,32);
		
		g2d.setFont(font);
		
		FontMetrics fm = g2d.getFontMetrics();
		fm.stringWidth(text);
		fm.getHeight();
		
		
		
		g2d.setColor(new Color(0));
		g2d.drawString(text, 0, fm.getAscent());
		
		g2d.dispose();
		
		try {
			
			ImageIO.write(img, "png", new File("/home/seven/Desktop/test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		wordToImg();
	}
	
	
}
