package wlg.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *  例如输入数组{901,9,1}，则打印出这三个数字能排成的最大数字99011
 */
public class BuildLargestNum {

    public String buildLargestNum(int[] nums){
        StringBuilder res = new StringBuilder();
        List<String> numStrs = new ArrayList<>();
        for(int e:nums){
            numStrs.add(String.valueOf(e));
        }
        numStrs.sort((a,b)->{
            return (b+a).compareTo(a+b);
        });
        for(String s:numStrs) {
            res.append(s);
        }
        return res.toString();
    }

    public String buildLargestNum2(int[] nums) {
        StringBuilder res = new StringBuilder();


        return res.toString();
    }

    public static void main(String[] args) {
        BuildLargestNum t = new BuildLargestNum();
        int[] nums = {901,9,1};
        String largestNum = t.buildLargestNum(nums);
        System.out.println(largestNum);
    }
}
