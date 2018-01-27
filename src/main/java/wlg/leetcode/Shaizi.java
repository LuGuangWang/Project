package wlg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shaizi {

	public static void main(String[] args) {
		
		findOne();
		findRes();
		List<Integer> arr= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,1,2,3,3,3));
		arr.sort((a,b)->b-a);
		boolean ishu = hu(arr,false);
		System.out.println("ishu:==="+ishu);
	}
	private static void findOne() {
		boolean ishu = false;
		for(int m=1;m<=9;m++) {
			List<Integer> arr= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,1,1,2,3));
			arr.add(m);
			arr.sort((a,b)->b-a);
			if(count(arr,m)>4) {
				ishu = false;
				break;
			}
			ishu = hu(arr,false);
			if(!ishu) {
				System.out.println(m);
				break;
			}
		}
		System.out.println(ishu);
	}
	
	private static boolean findOne(List<Integer> tmp) {
		boolean ishu = false;
		for(int m=1;m<=9;m++) {
			List<Integer> arr= new ArrayList<>(tmp);
			arr.add(m);
			arr.sort((a,b)->b-a);
			if(count(arr,m)>4) {
				ishu = false;
				break;
			}
			ishu = hu(arr,false);
			if(!ishu) {
				break;
			}
		}
		return ishu;
	}
	
	private static void findRes() {
		for(int i=1;i<=9;i++)
			for(int j=1;j<=9;j++)
				for(int l=1;l<=9;l++)
					for(int k=1;k<=9;k++) {
						List<Integer> arr= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
						arr.add(i);
						arr.add(j);
						arr.add(l);
						arr.add(k);
						boolean ishu = findOne(arr);
						if(ishu) {
							System.out.println(i+","+j+","+l+","+k);
						}
					}
	}
	/**
	 * 是否胡牌
	 * @param arr
	 * @return
	 */
	private static boolean hu(List<Integer> arr,boolean haspair) {
		boolean ishu = false;
		if(arr.size()==0 && haspair) {
			return true;
		}else if(arr.size()==1) {
			return false;
		}
		
		for(int i = 1;i<=3;i++) {
			if(i==1 && arr.size()>=3) {//顺子
				int pai = arr.get(arr.size()-1);
				ishu = arr.contains(pai+1) && arr.contains(pai+2);
				if(ishu) {
					List<Integer> tmp= new ArrayList<>(arr);
					tmp.remove((Integer)pai);
					tmp.remove((Integer)(pai+1));
					tmp.remove((Integer)(pai+2));
					ishu = hu(tmp,haspair);
				}
					
			}
			if(!ishu && i==3 && arr.size()>=3) {//碰
				int pai = arr.get(arr.size()-1);
				int a1 = arr.get(arr.size()-2);
				int a2 = arr.get(arr.size()-3);
				ishu = (a1==pai)&&(a2==pai);
				if(ishu) {
					List<Integer> tmp= new ArrayList<>(arr);
					tmp.remove(tmp.size()-1);
					tmp.remove(tmp.size()-1);
					tmp.remove(tmp.size()-1);
					ishu = hu(tmp,haspair);
				}
					
			}
			if(!ishu && i==2 && arr.size()>=2) {//对子
				int pai = arr.get(arr.size()-1);
				int a1 = arr.get(arr.size()-2);
				ishu = (a1==pai);
				if(ishu) {
					List<Integer> tmp= new ArrayList<>(arr);
					tmp.remove(tmp.size()-1);
					tmp.remove(tmp.size()-1);
					ishu = hu(tmp,true);
				}
			}
		}
		
		return ishu;
	}
	private static int count(List<Integer> arr, int pai) {
		int count = 0;
		for(int i=arr.size()-1;i>=0;i--) {
			if(arr.get(i)==pai) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}

}
