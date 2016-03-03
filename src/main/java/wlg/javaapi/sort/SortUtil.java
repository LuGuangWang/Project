package wlg.javaapi.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortBean s1 = new SortBean("1");
		SortBean s2 = new SortBean(null);
		SortBean s3 = new SortBean("4");
		SortBean s4 = new SortBean("3");
		List<SortBean> arrs = new ArrayList<SortBean>();
		arrs.add(s1);
		arrs.add(s2);
		arrs.add(s3);
		arrs.add(s4);
		Collections.sort(arrs);
		System.out.println(arrs.toString());
	}

}
