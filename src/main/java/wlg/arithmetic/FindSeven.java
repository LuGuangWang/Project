package wlg.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSeven {
	
	public List<String> findSeven(int[] bottles,int target){
		Map<String,Integer> validBottles = new HashMap<>(bottles.length);
		int sum = 0;
		List<String> res = null;
		//过滤掉10和0的瓶子
		for(int i=0;i<bottles.length;i++) {
			if(bottles[i]>0 && bottles[i]<10) {
				validBottles.put(String.valueOf(i), bottles[i]);
				sum+=bottles[i];
			}
		}
		//和大于等于7的才能组成7
		if(sum>=target) {
			res = new ArrayList<>();
			findSeven(validBottles,sum,target,res);
		}
		return res;
	}
	
	private List<String> findSeven(Map<String,Integer> validBottles,int sum,int target,List<String> result) {
		int water;
		List<String> labels = new ArrayList<>();
		if(validBottles.size()==1) {
			Object key = validBottles.keySet().toArray()[0];
			water = validBottles.get(key);
			if(water==target) {
				labels.add(key.toString());
			}
		}else {
			String[] bottles = validBottles.keySet().toArray(new String[validBottles.size()]);
			
			for(String key:bottles) {
				water = validBottles.remove(key);
				Map<String,Integer> nbottles = new HashMap<>(validBottles);
				int nsum = sum - water;
				int ntarget = target-water;
				if(nbottles.size()>=1 && ntarget>=0) {
					List<String> preLabels = findSeven(nbottles,nsum,ntarget,result);
					if(preLabels!=null && preLabels.size()>0){
						preLabels.forEach(label->{
							label = new StringBuilder().append(key).append(" ").append(label).toString();
							labels.add(label);
							if(target==7) {
								result.add(label);
							}
						});
					}else{
						continue;
					}
				}
			}
		}
		return labels;
	}

	public static void main(String[] args) {
		FindSeven t = new FindSeven();
		int[] bottles = {3,2,2,2,1};
		int target = 7;
		List<String> res = t.findSeven(bottles, target);
		if(res != null) {
			res.forEach(i -> {
				System.out.println(i);
			});
		}
	}
}
