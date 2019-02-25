package wlg.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author seven
 *
 */
public class BuildMinNum {
	
	private static String buildMinNum(int[] nums) {
		assert nums==null;
		StringBuilder res = new StringBuilder();
		List<String> strs = new ArrayList<>(nums.length);
		for(int e:nums) {
			strs.add(String.valueOf(e));
		}
		strs.sort((a,b)->{
			int s1 = Integer.parseInt(a+b);
			int s2 = Integer.parseInt(b+a);
			return s1 - s2;
		});
		for(String s:strs) {
			res.append(s);
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		int[] nums = {3,32,321};
		String res = buildMinNum(nums);
		System.out.println(res);
	}
}
