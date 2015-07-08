package com.main.util.collection;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		Bean b = new Bean();
		b.setTest("test");
		List<Bean> beans = new ArrayList<Bean>();
		beans.add(b);
		b.setTest("t");//属性的更改，会影响list里德对象值
		b=null;//不会影响已add到list里的内容
		System.out.println(beans.get(0).toString());
		
		
		List<List<Bean>> beanList = new ArrayList<List<Bean>>();
		System.out.println("beans:"+beans.toString());
		beanList.add(beans);
		beans.clear();
		System.out.println("beanList:"+beanList.toString());
	}

}
