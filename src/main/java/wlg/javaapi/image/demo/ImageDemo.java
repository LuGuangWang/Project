package wlg.javaapi.image.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDemo {
	private static int width = 296;
	private static int height = 128;
	private static int gap = 10;
	
	private static String skuName = "小米(MI)运动蓝牙耳机";
	private static String good = "好评度";
	private static String goodScore = "99.9%";
	private static String RMB = "¥";
	private static String price = "129.";
	
	public static void main(String[] args) {
		String image = "/home/seven/Desktop/image_demo.png";
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		//背景色
		Graphics2D panal = img.createGraphics();
		panal.setColor(Color.WHITE);
		panal.fillRect(0, 0, width, height);
		
		panal.setColor(Color.BLACK);
		/** ************ 第一行 ********** **/
		//商品名称
		Font font = new Font("Zfull-GB Bold 24",Font.PLAIN,24);
		panal.setFont(font);
		FontMetrics fm = panal.getFontMetrics();
		int fwidth = fm.stringWidth(skuName);
		int fheight = fm.getHeight();
		int center = (width - fwidth)/2;
		panal.drawString(skuName, center, fm.getAscent());
		//下划线
		panal.fillRect(0, fheight+1, width,1);
		/** ************ 第二行 ********** **/
		//好评度
		Font font2 = new Font("Zfull-GB Regular 13",Font.PLAIN,13);
		panal.setFont(font2);
		FontMetrics fm2 = panal.getFontMetrics();
		int gwidth = fm2.stringWidth(good);
		int gheight = fm2.getHeight();
		//要一直维护坐标 top_y  blow_y left_x
		int top_y = fheight+gap; 
		int blow_y = fheight+gap/2+gheight*2;
		int left_x = gap;
		//好评度 底部框
		panal.fillRoundRect(left_x, top_y, gwidth+gap, gheight*2, 10, 10);
		panal.setColor(Color.WHITE);
		panal.drawString(good, left_x+gap/2, blow_y-1);
		//好评度分数
		Font font3 = new Font("Arial Regular 10",Font.PLAIN,10);
		panal.setFont(font3);
		FontMetrics fm3 = panal.getFontMetrics();
		int swidth = fm3.stringWidth(goodScore);
		fm3.getHeight();
		panal.drawString(goodScore,gap+(gwidth-swidth)/2+gap/2,blow_y-gheight);
		//价格符号
		left_x = gwidth + gap * 2;
		panal.setColor(Color.BLACK);
		Font font4 = new Font("Arial Regular 10",Font.BOLD,10);
		panal.setFont(font4);
		FontMetrics fm4 = panal.getFontMetrics();
		int rwidth = fm4.stringWidth(RMB);
		fm4.getHeight();
		panal.drawString(RMB,left_x+1,blow_y);
		//价格整数部分
		left_x += rwidth;
		
		
		//商品属性
		
		//二维码
		panal.dispose();
		try {
			ImageIO.write(img, "png", new File(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
