package wlg.arithmetic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 数组中的逆序对 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007.
 * 输入描述：题目保证输入的数组中没有的相同的数字 
 * 数据范围： 
 * 对于%50的数据,size<=10^4 
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 
 * 改进的归并排序，分而治之，时间复杂度O(n * log(n))，空间复杂度O(n)
 * 
 * @author seven
 *
 */
public class ReversePairs {

	public void reversePairs(int[] arr,int start,int end, AtomicInteger count) {
		if((end-start)<=0) {
			return;
		}
		int mid = (start + end) / 2;
		reversePairs(arr, start, mid, count);
		reversePairs(arr, mid+1, end, count);
		//排序归并
		int[] tmp = new int[end-start+1];
		int i=0,i1 = start,i2 = mid+1;
		while(i1<=mid && i2<=end) {
			if(arr[i1]<=arr[i2]) {
				tmp[i] = arr[i1++];
			}else {
				//第一段{5,6}的最小值5大于第二段{0,7}的0
//				count.addAndGet(mid - i1 + 1);
				
				int curCount = (mid - i1 + 1) % 1000000007;
				count.addAndGet(curCount);
				int res = count.get() % 1000000007;
				count.set(res);
				
				tmp[i] = arr[i2++];
			}
			i ++;
		}
		while(i1<=mid) {
			tmp[i++] = arr[i1++];
		}
		while(i2<=end) {
			tmp[i++] = arr[i2++];
		}
		//排好序的数据回写到数组区间
		for(i=0;i<tmp.length;i++) {
			arr[start+i] = tmp[i];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5,6,7,0};
		ReversePairs r = new ReversePairs();
		AtomicInteger count = new AtomicInteger(0);
		r.reversePairs(arr, 0, arr.length-1, count);
		System.out.println(count.get());
	}
}
