package wlg.javaapi.image.demo;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQRCode {
	private final static CreateQRCode instance = new CreateQRCode();

	private CreateQRCode() {
	}

	public static CreateQRCode $() {
		return instance;
	}

	// 用于设置QR二维码参数
	private static Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
		private static final long serialVersionUID = 1L;
		{
			// 设置QR二维码的纠错级别（H为最高级别）
			put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			put(EncodeHintType.CHARACTER_SET, "UTF-8");// 设置编码方式
			put(EncodeHintType.MARGIN, 0);
		}
	};
	private static final int QRCOLOR = 0xFF000000; // 默认是黑色
	private static final int BGWHITE = 0xFFFFFFFF; // 背景颜色

	public BufferedImage createQCode(String url, int width, int height) {
		BufferedImage image = null;
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			BitMatrix bm = multiFormatWriter.encode(url, BarcodeFormat.QR_CODE, width, height, hints);
		
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			// 开始利用二维码数据创建Bitmap图片
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
				}
			}
			image.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}
