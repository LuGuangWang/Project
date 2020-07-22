package wlg.leetcode;

import java.util.ArrayList;
import java.util.List;

//整型数组，n个数的和等于m的组合
public class NSumM {

    List<List<Integer>> res = new ArrayList<>();
    /**
     *f(m,n) = f(i)+f(m-f(i),n-i)
     *
     * @param nums
     * @param m
     * @param n
     */
    public void buildNSumM(int[] nums, int m, int n, int inx,List<Integer> startNums){
        if(n == 1){
            for(int i=inx;i<nums.length;i++){
                if(nums[i] == m){
                    List<Integer> tmp = new ArrayList<>(startNums);
                    tmp.add(m);
                    res.add(tmp);
//                    System.out.print(startNums);
//                    System.out.println(m);
                }
            }
        } else {
            for(int i=inx;i<nums.length;i++){
                List<Integer> finalNums = new ArrayList<>();
                int num = nums[i];
                finalNums.addAll(startNums);
                finalNums.add(num);
                buildNSumM(nums,m-num,n-1,i+1,finalNums);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        NSumM s = new NSumM();
        s.buildNSumM(nums,10,3,0,new ArrayList<>());

        System.out.println(s.res);
    }
}
