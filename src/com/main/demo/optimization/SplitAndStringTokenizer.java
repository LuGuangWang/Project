package com.main.demo.optimization;

import java.util.StringTokenizer;

/**
 * String 的 split 方法支持传入正则表达式帮助处理字符串，操作较为简单，但是缺点是它所依赖的算法在对简单的字符串分割时性能较差。
 * 清单 5 所示代码对比了 String 的 split 方法和调用 StringTokenizer 类来处理字符串时性能的差距。
 * 
 * 
 * 
 * 仔细观察粗体这行代码我们发现 String.substring()所返回的 String 仍然会保存原始 String
 * 从一个巨大的 String 截取少数 String 为以后所用，这样的设计则造成大量冗余数据
 * 
 * 从以上定量的分析看来，当需要截取的字符串长度总和大于等于原始文本长度，
 * 本文所建议的方法带来的空间复杂度反而高了，而现有的 String.substring()设计恰好可以共享原始文本从而达到节省内存的目的。
 * 反之，当所需要截取的字符串长度总和远小于原始文本长度时，用本文所推荐的方法将在很大程度上节省内存，在大文本数据处理中其优势显而易见。
 * @author Administrator
 *
 */
public class SplitAndStringTokenizer {
	public static void main(String[] args) {
		String orgStr = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
			sb.append(",");
		}
		orgStr = sb.toString();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			orgStr.split(",");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		String orgStr1 = sb.toString();
		StringTokenizer st = new StringTokenizer(orgStr1, ",");
		for (int i = 0; i < 1000; i++) {
			st.nextToken();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		String orgStr2 = sb.toString();
		String temp = orgStr2;
		while (true) {
			String splitStr = null;
			int j = temp.indexOf(",");
			if (j < 0)
				break;
			splitStr = temp.substring(0, j);
			temp = temp.substring(j + 1);
		}
		temp = orgStr2;
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
