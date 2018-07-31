package wlg.javaapi.lambda;

import java.util.function.Function;

public class FunctionTest {
	public int test(int tmp,int t,Function<Integer, Integer> add) {
		return add.apply(tmp);
	}
	
	public static int ten(int m) {
		System.out.println("m:" + m);
		return 20;
	}
	
	public void run(MyTask task) {
		System.out.println("===== run task");
		
		int a = task.test(1, 2,3);
		System.out.println("a==== " + a);
	}
	
	public static void main(String[] args) {
		FunctionTest f = new FunctionTest();
		
//		int result = f.test(0,5,m -> ten(m));
//		System.out.println(result);
		
		f.run((a,b,c) -> {
				System.out.println("a: " + a);
				System.out.println("b: " + b);
				System.out.println("c: " + c);
				return ten(a);
			});
		
	}
	
	
	
	public interface MyTask{
		int test(int a,int b,int c);
	}
}


