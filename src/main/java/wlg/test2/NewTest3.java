package wlg.test2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

public class NewTest3 {
	private  static Object o;
	private ReentrantLock lock = new ReentrantLock();
	private int c = 0;
	
	
	public void setA(int b) {
		if(o==null) {
			synchronized(Object.class) {
				System.out.println("o2: " + o);
				
				if(o == null) {
					System.out.println("=========");
					Object n = new Object();
					System.out.println("n: " + n);
					o = n;
					n=null;
				}
			}
		}
	}
	
	public void setB(int b) {
		if(o==null) {
			lock.lock();
			try {
				System.out.println("o2: " + o);
				if(o == null) {
					System.out.println("=========1");
					Object n = new Object();
					System.out.println("n: " + n);
					o = n;
					n=null;
				}
			}finally {
				lock.unlock();
			}
		}
	}
	
	public void setC() {
		lock.lock();
		try {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c = c+1;
		}finally {
			lock.unlock();
		}
	}
	
	public void setC1() {
		synchronized(this) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c = c+1;
		}
	}
	
	public void getC() {
		System.out.println("c====== " + c);
	}
	
	public void getA() {
		System.out.println("o: " + o);
	}
	
	public void t() {
		
	}
	
	public int test(int p) {
		return 0;
	}
	
	public int test1(Function<Integer, Integer> f) {
		return 0;
	}
	
	public void test2(My my) {
		
	}
	
	public static void main(String[] args) throws Exception {
		NewTest3 n = new NewTest3();
		n.test1(n::test);
		n.test2(n::t);
		CountDownLatch lock = new CountDownLatch(100);
		for(int i=0;i<100;i++)
			new Thread(()-> {
//				NewTest3 a1 = new NewTest3();
//				a1.setC();
				n.setC1();
				lock.countDown();
			}).start();
		
		lock.await();
		n.getC();
	}
	
	private interface My{
		void my();
	}
}
