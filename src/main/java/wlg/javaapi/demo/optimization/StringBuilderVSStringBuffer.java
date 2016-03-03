package wlg.javaapi.demo.optimization;

/**
 * StringBuilder 数据并没有按照预想的方式进行操作。
 * StringBuilder 和 StringBuffer 的扩充策略是将原有的容量大小翻倍，
 * 以新的容量申请内存空间，建立新的 char 数组，然后将原数组中的内容复制到这个新的数组中。
 * 因此，对于大对象的扩容会涉及大量的内存复制操作。如果能够预先评估大小，会提高性能
 * @author Administrator
 *
 */
public class StringBuilderVSStringBuffer {
	public StringBuffer contents = new StringBuffer();
	public StringBuilder sbu = new StringBuilder();

	public void log(String message) {
		for (int i = 0; i < 10; i++) {
			/*
			 * contents.append(i); contents.append(message);
			 * contents.append("\n");
			 */
			contents.append(i);
			contents.append("\n");
			sbu.append(i);
			sbu.append("\n");
		}
	}

	public void getcontents() {
		// System.out.println(contents);
		System.out.println("start print StringBuffer");
		System.out.println(contents);
		System.out.println("end print StringBuffer");
	}

	public void getcontents1() {
		// System.out.println(contents);
		System.out.println("start print StringBuilder");
		System.out.println(sbu);
		System.out.println("end print StringBuilder");
	}

	public static void main(String[] args) throws InterruptedException {
		StringBuilderVSStringBuffer ss = new StringBuilderVSStringBuffer();
		runthread t1 = new runthread(ss, "love");
		runthread t2 = new runthread(ss, "apple");
		runthread t3 = new runthread(ss, "egg");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}

}

class runthread extends Thread {
	String message;
	StringBuilderVSStringBuffer buffer;

	public runthread(StringBuilderVSStringBuffer buffer, String message) {
		this.buffer = buffer;
		this.message = message;
	}

	public void run() {
		while (true) {
			buffer.log(message);
			// buffer.getcontents();
			buffer.getcontents1();
			try {
				sleep(5000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
