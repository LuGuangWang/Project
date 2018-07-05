package wlg.test;

import org.python.util.PythonInterpreter;

public class PythonTest {

	public static void main(String[] args) {
		
		try {
			Process proc = Runtime.getRuntime().exec("bash /bigdata/code/models/tutorials/image/imagenet/run.sh");
			proc.waitFor();
		} catch (Exception e) {
			System.out.println("==========");
			e.printStackTrace();
		}
		
		
		test1();
	}

	private static void test1() {
		PythonInterpreter i = new PythonInterpreter();
		i.exec("print('hello')");
		i.close();
	}

}
