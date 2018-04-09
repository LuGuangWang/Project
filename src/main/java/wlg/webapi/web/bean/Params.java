package wlg.webapi.web.bean;

import java.util.List;

import wlg.webapi.BaseObject;

public class Params extends BaseObject{
	private String name;
	private String code;
	private List<Params> vals;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Params> getVals() {
		return vals;
	}
	public void setVals(List<Params> vals) {
		this.vals = vals;
	}
	
}
