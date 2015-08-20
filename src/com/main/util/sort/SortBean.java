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
	  if(uniqueId ==null){
	    return 1;
	  }else if(o.getUniqueId()==null)
	    return -1;
	  
		return o.getUniqueId().compareTo(uniqueId);
	}

	public String toString(){
		return "uniqueId:"+uniqueId;
	}
}
