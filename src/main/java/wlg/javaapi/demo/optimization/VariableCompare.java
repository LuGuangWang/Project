package wlg.javaapi.demo.optimization;

/**
 * 局部变量的访问速度远远高于类的成员变量。
 * 
 * 用方法时传递的参数以及在调用中创建的临时变量都保存在栈 (Stack) 里面，读写速度较快。
 * 其他变量，如静态变量、实例变量等，都在堆 (heap) 中创建，读写速度较慢。
 * 代码演示了使用局部变量和静态变量的操作时间对比。
 * 
 * @author Administrator
 *
 */
public class VariableCompare {
	public static int b = 0;

	public static void main(String[] args) {
		long starttime = System.currentTimeMillis();
		int a = 0;
		for (int i = 0; i < 1000000; i++) {
			a++;// 在函数体内定义局部变量
		}
		System.out.println(System.currentTimeMillis() - starttime);

		starttime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			b++;// 类的成员变量
		}
		System.out.println(System.currentTimeMillis() - starttime);
	}
}
