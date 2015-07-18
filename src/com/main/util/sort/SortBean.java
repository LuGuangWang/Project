package com.main.util.sort;

public class SortBean implements Comparable<SortBean> {

	private String uniqueId;
	
	SortBean(String uniqueId){
		this.uniqueId = uniqueId;
	}
	
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public int compareTo(SortBean o) {
		return uniqueId.compareTo(o.getUniqueId());
	}

	public String toString(){
		return "uniqueId:"+uniqueId;
	}
}
