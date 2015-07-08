package com.main.util.clone;

public class CloneBean implements Cloneable {
	private String userId;
	private String userName;
	private String testMesg;
	public String getTestMesg() {
		return testMesg;
	}
	public void setTestMesg(String testMesg) {
		this.testMesg = testMesg;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//重写clone方法
	public Object clone(){
		Object o = null;
		try {
			o = super.clone();
		}catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		return o;
	}
	public String toString(){
		return "this object is:" + userId + "," + userName + "," + testMesg;
	}
}
