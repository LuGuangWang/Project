package wlg.javaapi.image.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class CreateImage {

	public static void main(String[] args) {
		CreateImage createImage = new CreateImage();

		try {
			String text = createImage.readToString("src/main/java/wlg/javaapi/image/demo/image.json");
			System.out.println(text);
			String image = "/home/seven/Desktop/image_demo.png";
			BufferedImage img = createImage.createImg(text);
			ImageIO.write(img, "png", new File(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private BufferedImage createImg(String imgJson) {
		BufferedImage img = null;
		try {
			JSONObject json = JSONObject.parseObject(imgJson);

			// 宽 高
			int width = json.getIntValue(ImgJL.width);
			int height = json.getIntValue(ImgJL.height);
			// 具体布局
			JSONArray content = json.getJSONArray(ImgJL.contents);

			img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D panel = img.createGraphics();

			content.forEach(obj -> {
				JSONObject item = (JSONObject) obj;
				// 控件类型
				String type = String.valueOf(item.getOrDefault(ImgJL.type, ImgJL.txt)).toLowerCase();
				switch (type) {
				case ImgJL.txt:
					addTxtComponent(panel, item);
					break;
				case ImgJL.QR_Code:
					addQRCode(panel, item);
					break;
				case ImgJL.rect:
					addRect(panel,item);
					break;
				case ImgJL.round_rect:
					addRoundRect(panel,item);
					break;
				default:
					break;
				}
			});
			panel.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
	private void addRoundRect(Graphics2D panel, JSONObject item) {
		int x = item.getIntValue(ImgJL.x);
		int y = item.getIntValue(ImgJL.y);
		int width = item.getIntValue(ImgJL.width);
		int height = item.getIntValue(ImgJL.height);
		int arcwidth = item.getIntValue(ImgJL.arcwidth);
		int archeight = item.getIntValue(ImgJL.archeight);
		setColor(panel, item.getOrDefault(ImgJL.color, "").toString());
		panel.drawRoundRect(x, y, width, height,arcwidth,archeight);
	}

	//添加矩形
	private void addRect(Graphics2D panel, JSONObject item) {
		int x = item.getIntValue(ImgJL.x);
		int y = item.getIntValue(ImgJL.y);
		int width = item.getIntValue(ImgJL.width);
		int height = item.getIntValue(ImgJL.height);
		setColor(panel, item.getOrDefault(ImgJL.color, "").toString());
		panel.fillRect(x, y, width, height);
	}

	// 添加二维码
	private void addQRCode(Graphics2D panel, JSONObject item) {
		String url = item.getOrDefault(ImgJL.content, "").toString();
		int QRsize = item.getIntValue(ImgJL.size);
		int x = item.getIntValue(ImgJL.x);
		int y = item.getIntValue(ImgJL.y);
		BufferedImage QRCode = CreateQRCode.$().createQCode(url, QRsize, QRsize);
		panel.drawImage(QRCode, x, y, null);
	}

	// 添加文字
	private void addTxtComponent(Graphics2D panel, JSONObject item) {
		setFont(panel, item);
		setColor(panel, item.getOrDefault(ImgJL.color, "").toString());
		String txt = item.getOrDefault(ImgJL.content, "").toString();
		int x = item.getIntValue(ImgJL.x);
		int y = item.getIntValue(ImgJL.y);
		panel.drawString(txt, x, y);
	}

	// 设置字体
	private void setFont(Graphics2D panel, JSONObject item) {
		String fontType = item.getOrDefault(ImgJL.font_type, "Zfull-GB Regular").toString();
		int fontBold = item.getIntValue(ImgJL.bold);
		int fontSize = item.getIntValue(ImgJL.size);
		Font font = new Font(fontType, fontBold, fontSize);
		panel.setFont(font);
	}

	// 设置颜色
	private void setColor(Graphics2D panel, String color) {
		switch (color) {
		case ImgJL.white:
			panel.setColor(Color.WHITE);
			break;
		default:
			panel.setColor(Color.BLACK);
			break;
		}
	}

	public String readToString(String fileName) {
		File f = new File(fileName);
		String result = null;
		try (FileInputStream in = new FileInputStream(f)) {
			Long filelength = f.length();
			byte[] filecontent = new byte[filelength.intValue()];
			in.read(filecontent);
			result = new String(filecontent, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
