package wlg.javaapi.demo.optimization;

/**
 *  处理超大 String 对象的示例代码
 * @author Administrator
 *
 */
public class StringConcat {
	public static void main(String[] args) {
		String str = null;
		String result = "";

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			str = str + i;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			result = result.concat(String.valueOf(i));
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		/**
		 * StringBuffer 和 StringBuilder 都实现了 AbstractStringBuilder 抽象类，
		 * 拥有几乎相同的对外借口，两者的最大不同在于 StringBuffer 对几乎所有的方法都做了同步，
		 * 而 StringBuilder 并没有任何同步。由于方法同步需要消耗一定的系统资源，
		 * 因此，StringBuilder 的效率也好于 StringBuffer。 
		 * 但是，在多线程系统中，StringBuilder 无法保证线程安全，不能使用.
		 */
		start = System.currentTimeMillis();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 10000; i++) {
			buf.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}