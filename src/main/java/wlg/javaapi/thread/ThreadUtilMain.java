/**
 * 
 */
package wlg.javaapi.thread;

/**
 * @author Administrator
 *
 */
public class ThreadUtilMain {

	private static class MultipleThread implements Runnable{
		
		@Override
		public void run() {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			String threadName = Thread.currentThread().getName();
			System.out.format("%s%n", threadName);
		}
		
	}
	
	/**
	 * 
	 */
	public ThreadUtilMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//lambda 
		Thread thread = new Thread(new MultipleThread());
		Thread thread2 = new Thread(new MultipleThread());
		thread.start();
		try {
			thread.join(5000);//等待子线程结束
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread2.start();
	}

}
