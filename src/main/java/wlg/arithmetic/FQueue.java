package wlg.arithmetic;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 思路：
 * s1用来入栈；出栈时，先将s1元素压人s2空栈，然后读取s2栈顶元素
 * @author seven
 *
 */
public class FQueue {
	private Stack<Object> s1 = new Stack<>();
	private Stack<Object> s2 = new Stack<>();
	
	public Object pop() {
		Stack<Object> tmp = null,empty = null;
		if(s1.empty()) {
			empty = s1;
			tmp = s2;
		}else {
			empty = s1;
			tmp = s2;
		}
		while(!tmp.empty()) {
			empty.push(tmp.pop());
		}
		
		return empty.empty()?null:empty.pop();
	}
	
	public void push(Object obj) {
		Stack<Object> tmp = s1.empty()?s2:s1;
		tmp.push(obj);
	}
	
	public static void main(String[] args) {
		FQueue f = new FQueue();
		f.push(1);
		f.push(2);
		f.push(3);
		f.push(4);
		System.out.println(f.pop());
	}
}
