package wlg.javaapi.demo.optimization;

/**
 * 位运算是所有的运算中最为高效的。因此，可以尝试使用位运算代替部分算数运算，
 * 来提高系统的运行速度。最典型的就是对于整数的乘除运算优化。
 * 
 * 代码是一段使用算数运算的实现。
 * @author Administrator
 *
 */
public class YunSuan {
	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		long a = 1000;
		for (int i = 0; i < 10000000; i++) {
			a *= 2;
			a /= 2;
		}
		System.out.println(a);
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			a <<= 1;
			a >>= 1;
		}
		System.out.println(a);
		System.out.println(System.currentTimeMillis() - start);
	}
}
