package wlg.javaapi.demo.optimization;

import java.util.*;

/**
 * String方面的优化
 * 
 * 在一个很大的 string 独享里面截取一段很小的字符串，
 * 如果采用 string 的 substring 方法会造成内存溢出，
 * 如果采用反复创建新的 string 方法可以确保正常运行。
 * 
 * @author Administrator
 *
 */
public class StringOptimizeMain {

	public static void main(String[] args) {
		List<String> handler = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			HugeStr h = new HugeStr();
			ImprovedHugeStr h1 = new ImprovedHugeStr();
			handler.add(h.getSubString(1, 5));
			handler.add(h1.getSubString(1, 5));
		}
	}

	static class HugeStr {
		private String str = new String(new char[800000]);

		public String getSubString(int begin, int end) {
			return str.substring(begin, end);
		}
	}

	/**
	 * ImprovedHugeStr 可以工作是因为它使用没有内存泄漏的 String 构造函数重新生成了 String 对象，
	 * 使得由 substring() 方法返回的、存在内存泄漏问题的 String 对象失去所有的强引用，
	 * 从而被垃圾回收器识别为垃圾对象进行回收，保证了系统内存的稳定。
	 * @author Administrator
	 *
	 */
	static class ImprovedHugeStr {
		private String str = new String(new char[10000000]);

		public String getSubString(int begin, int end) {
			return new String(str.substring(begin, end));
		}
	}

}
