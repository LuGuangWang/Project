/**
 * 
 */
package com.main.util.set;

import java.util.*;

/**
 * @author wangluguang
 *
 */
public class SetUtil {
	SetUtil(){
		
	}
	public static void main(String[] args){
		Set<DataBean> datas = new HashSet<DataBean>();
		DataBean data1 = new DataBean("W","1");
		DataBean data2 = new DataBean("W","3");
		DataBean data3 = new DataBean("L","2");
		DataBean data4 = new DataBean("L","2");
		datas.add(data1);
		datas.add(data2);
		datas.add(data3);
		datas.add(data4);
		System.out.println(datas.toString());
		
		List<DataBean> datas3 = new ArrayList<DataBean>();
		datas3.add(data1);
		datas3.add(data2);
		datas3.add(data3);
		datas3.add(data4);
		
		for(int i=0;i<datas3.size();){
			DataBean data = datas3.get(i);
			if(data.getName().equals("W"))
				data.setName("S");
			else
				datas3.remove(data);
		}
		
		System.out.println(datas3.toString());
		
		List<DataBean2> datas2= new ArrayList<DataBean2>();
		DataBean2 data11 = new DataBean2("W","1");
		DataBean2 data22 = new DataBean2("W","3");
		DataBean2 data33 = new DataBean2("L","2");
		DataBean2 data44 = new DataBean2("L","2");
		datas2.add(data11);
		datas2.add(data22);
		datas2.add(data33);
		datas2.add(data44);
		System.out.println(datas2.toString());
	}
}
