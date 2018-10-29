package wlg.javaapi.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

public class ImageTest {
	
	public static void main(String[] args) throws Exception {
		String imgPath = "/home/seven/Desktop/logo/huangjia.jpg";
		Map<Integer,Integer> param = new HashMap<>();
		BufferedImage img = ImageIO.read(new File(imgPath));
		for(int y=0;y<img.getHeight();y++) {
//			System.out.print("第"+y+"行: ");
			for(int x=0;x<img.getWidth();x++) {
				Color pixel = new Color(img.getRGB(x, y));
				int gray = getGray(pixel);
				if(param.containsKey(gray)) {
					int val = param.get(gray) + 1;
					param.put(gray, val);
				}else {
					param.put(gray, 1);
				}
//				System.out.printf("%3s ",gray);
			}
//			System.out.println();
		}
		System.out.println("像素值总数：" + param.keySet().size());
		int max = 1,min = 255,maxVal=1,minVal=255;
		for(Entry<Integer, Integer> e:param.entrySet()) {
			if(e.getValue()>maxVal) {
				maxVal = e.getValue();
				max = e.getKey();
			}
			if(e.getValue()<minVal) {
				minVal = e.getValue();
				min = e.getKey();
			}
			System.out.println(e.getKey() + " , " + e.getValue());
		}
		int dis = min + (max-min)/2;
		
		System.out.println(max + " , " + min + " , " +dis);
		
		erzhitu(imgPath,dis,"/home/seven/Desktop/gray2.jpg");
		erzhitu(imgPath,max-min,"/home/seven/Desktop/gray.jpg");
	}

	private static void erzhitu(String imgPath,int threshold,String target) throws IOException {
		BufferedImage original = ImageIO.read(new File(imgPath));

		BufferedImage img = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		final Graphics2D panel = img.createGraphics();
		panel.drawImage(original.getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING), 0, 0, null);

		for(int y=0;y<img.getHeight();y++) {
//			System.out.print("第"+y+"行: ");
			for(int x=0;x<img.getWidth();x++) {
				Color pixel = new Color(img.getRGB(x, y));
				int gray = getGray(pixel);
				if(gray<threshold) {
					gray = 0;
				}else if(gray>threshold){
					gray = 255;
				}
				int rgb = new Color(gray,gray,gray).getRGB();
				img.setRGB(x, y, rgb);
			}
//			System.out.println();
		}
		ImageIO.write(img, "jpg", new File(target));
	}
	
	public static int getGray(Color pixel) {
		float pix = pixel.getRed() * 0.299f + pixel.getGreen() * 0.587f + pixel.getBlue() * 0.114f;
		return Math.round(pix);
	}
}
