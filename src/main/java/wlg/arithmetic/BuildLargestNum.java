package wlg.arithmetic;

import java.util.ArrayList;
import java.util.List;

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
