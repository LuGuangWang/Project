package wlg.javaapi.set;

public class DataBean2 {
	private String name;
	private String value;
	
	DataBean2(String name,String value){
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String toString(){
		return name+":"+value;
	}
}
