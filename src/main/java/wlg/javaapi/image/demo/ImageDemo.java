package wlg.javaapi.image.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

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
	private static String price_dot = "99";
	private static String comment = "设计优良；音质极佳";
	private static String skuProp = "产地：中国 规格：见包装 单位：个  等级：合格";
	private static String blow = "商品编码:3926295 监督电话:400-606-5500 举报电话:12358";
	private static String QCode = "/home/seven/Desktop/05.png";
	private static String scan = "扫一扫看商品详情";
	
	public static void main(String[] args) {
		try {
			String image = "/home/seven/Desktop/image_demo.png";
			BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			// 背景色
			Graphics2D panal = img.createGraphics();
			panal.setColor(Color.WHITE);
			panal.fillRect(0, 0, width, height);

			panal.setColor(Color.BLACK);
			/** ************ 第一行 ********** **/
			// 商品名称
			Font font = new Font("Zfull-GB Bold 24", Font.PLAIN, 24);
			panal.setFont(font);
			FontMetrics fm = panal.getFontMetrics();
			int fwidth = fm.stringWidth(skuName);
			int fheight = fm.getHeight();
			int center = (width - fwidth) / 2;
			panal.drawString(skuName, center, fm.getAscent());
			// 下划线
			panal.fillRect(0, fm.getAscent() + 1, width, 1);
			/** ************ 第二行 ********** **/
			// 好评度
			Font font2 = new Font("Zfull-GB Regular 13", Font.PLAIN, 13);
			panal.setFont(font2);
			FontMetrics fm2 = panal.getFontMetrics();
			int gwidth = fm2.stringWidth(good);
			int gheight = fm2.getHeight();
			// 要一直维护坐标 top_y blow_y left_x
			int top_y = fheight + gap;
			int blow_y = fheight + gap / 2 + gheight * 2;
			int left_x = gap;
			// 好评度 底部框
			panal.fillRoundRect(left_x, top_y, gwidth + gap, gheight * 2, 10, 10);
			panal.setColor(Color.WHITE);
			panal.drawString(good, left_x + gap / 2, blow_y - 1);
			// 好评度分数
			Font font3 = new Font("Arial Regular 10", Font.PLAIN, 10);
			panal.setFont(font3);
			FontMetrics fm3 = panal.getFontMetrics();
			int swidth = fm3.stringWidth(goodScore);
			fm3.getHeight();
			panal.drawString(goodScore, gap + (gwidth - swidth) / 2 + gap / 2, blow_y - gheight);
			// 价格符号
			left_x = gwidth + gap * 2;
			panal.setColor(Color.BLACK);
			Font font4 = new Font("Arial Bold 10", Font.PLAIN, 10);
			panal.setFont(font4);
			FontMetrics fm4 = panal.getFontMetrics();
			int rwidth = fm4.stringWidth(RMB);
			fm4.getHeight();
			panal.drawString(RMB, left_x + 1, blow_y);
			// 价格整数部分
			left_x += rwidth;
			Font font5 = new Font("Arial Bold 44", Font.PLAIN, 44);
			panal.setFont(font5);
			FontMetrics fm5 = panal.getFontMetrics();
			int pwidth = fm5.stringWidth(price);
			fm5.getHeight();
			panal.drawString(price, left_x + 1, blow_y);
			// 价格小数部分
			left_x += pwidth;
			top_y += gap;
			Font font6 = new Font("Arial Bold 16", Font.PLAIN, 16);
			panal.setFont(font6);
			FontMetrics fm6 = panal.getFontMetrics();
			int pdwidth = fm5.stringWidth(price_dot);
			fm6.getHeight();
			panal.drawString(price_dot, left_x + 1, top_y);
			// 评论词
			panal.drawRoundRect(gap, blow_y + gap, left_x + pdwidth / 2, 20, 20, 20);

			Font font7 = new Font("Zfull-GB Regular 16", Font.PLAIN, 16);
			panal.setFont(font7);
			FontMetrics fm7 = panal.getFontMetrics();
			int cwidth = fm7.stringWidth(comment);
			fm7.getHeight();
			panal.drawString(comment, (left_x + pdwidth / 2 - cwidth) / 2 + gap, blow_y + 20 + 5);

			// 商品属性
			blow_y = blow_y + gap + 20;
			Font font8 = new Font("Zfull-GB Regular 10", Font.PLAIN, 10);
			panal.setFont(font8);
			FontMetrics fm8 = panal.getFontMetrics();
			fm8.stringWidth(skuProp);
			fm8.getHeight();
			panal.drawString(skuProp, gap, blow_y + gap);
			left_x += pdwidth;

			// 底部
			Font font9 = new Font("Zfull-GB Regular 10", Font.PLAIN, 10);
			panal.setFont(font9);
			FontMetrics fm9 = panal.getFontMetrics();
			fm9.stringWidth(blow);
			fm9.getHeight();
			panal.drawString(blow, gap, height - 5);
			left_x += pdwidth;

			// 二维码
			Font font10 = new Font("Zfull-GB Regular 10", Font.PLAIN, 10);
			panal.setFont(font10);
			FontMetrics fm10 = panal.getFontMetrics();
			int sw = fm10.stringWidth(scan);
			fm10.getHeight();
			panal.drawString(scan, width-gap-sw, gap*4);
			
			BufferedImage qcode = ImageIO.read(new File(QCode));
			panal.drawImage(qcode,width-gap-60,gap*5,null);

			panal.dispose();

			ImageIO.write(img, "png", new File(image));
		} catch (Exception e) {
			System.out.println("==========error");
		}
	}
}
