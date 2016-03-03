package wlg.javaapi.clone;

import java.util.ArrayList;
import java.util.List;

public class CloneBean implements Cloneable {
	private String userId;
	private String userName;
	private String testMesg;
	private List<Bean> isClone;
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
	public List<Bean> getIsClone() {
    return isClone;
  }
  public void setIsClone(List<Bean> isClone) {
    this.isClone = isClone;
  }
  //重写clone方法
	public Object clone(){
	  CloneBean o = null;
		try {
		  o = (CloneBean)super.clone();
		  List<Bean> beans = new ArrayList<Bean>();
		  for(Bean s:o.getIsClone()){
		    beans.add((Bean) s.clone());
		  }
		  o.setIsClone(beans);
		}catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		return o;
	}
	public String toString(){
		return "this object is:  " + userId + " , " + userName + " , " + testMesg +" , "+ isClone;
	}
}
