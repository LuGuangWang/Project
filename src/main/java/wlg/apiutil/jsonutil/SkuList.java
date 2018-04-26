package wlg.apiutil.jsonutil;

import java.util.List;

public class SkuList {
	private String storeId; 
	private List<SkuList> skuList;
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public List<SkuList> getSkuList() {
		return skuList;
	}
	public void setSkuList(List<SkuList> skuList) {
		this.skuList = skuList;
	}
	
}
