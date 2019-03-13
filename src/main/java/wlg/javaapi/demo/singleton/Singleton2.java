package wlg.javaapi.demo.singleton;
/**
 * 静态内部类方式单例模式
 * @author seven
 *
 */
public class Singleton2 {
	
	private static class Inner{
		private final static Singleton2 INS = new Singleton2();
	}
	
	public static Singleton2 getIns() {
		return Inner.INS;
	}
	
	public static void main(String[] args) {
//		Singleton2.getIns();
		Singleton3.INS.method();
		System.out.println("tst");
	}
}
