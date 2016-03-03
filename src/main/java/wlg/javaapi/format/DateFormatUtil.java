package wlg.javaapi.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatUtil {

	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public String formatDate(String date){
		try {
			return date == null ? null : df.parse(date).toString();
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		DateFormatUtil date = new DateFormatUtil();
		System.out.println(date.formatDate("2015-05-05 10:00:00"));
		

	}

}
