/**
 * 
 */
package com.main.util.clone;

/**
 * @author Administrator
 *
 */
public class CloneUtilMain {

	/**
	 * 
	 */
	public CloneUtilMain() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CloneBean bean = new CloneBean();
		bean.setUserId("wlg");
		bean.setUserName("seven");
		CloneBean bean3 = bean;//没有被clone的对象，对其进行操作会影响原对象
		bean3.setTestMesg("this is not cloned");
		CloneBean bean2 = (CloneBean)bean.clone();
		bean2.setTestMesg("this is cloned");
		System.out.println(bean.toString());
		System.out.println(bean2.toString());
		System.out.println(bean3.toString());
	}

}
