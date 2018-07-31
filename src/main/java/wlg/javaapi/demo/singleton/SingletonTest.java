package wlg.javaapi.demo.singleton;

public class SingletonTest {

	private static volatile SingletonTest instance = null;
	private final static Object lock = new Object();
	
	private SingletonTest() {}
	
	public static SingletonTest $() {
		if(instance==null) {
			synchronized(lock){
				if(instance==null) {
					instance = new SingletonTest();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		
		
		SingletonTest in = SingletonTest.$();
		System.out.println(in);
	}
}
