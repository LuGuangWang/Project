package wlg.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class SubSeqLength {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,9,11,12,13,14,15,16};

        int a = subSeqLength(nums);
        System.out.println(a);
    }

    public static int subSeqLength(int[] nums){
        int len = 0;
        if(nums != null && nums.length>0){
            Map<Integer,Integer> dic = new HashMap<>(nums.length);
            for(int num:nums){
                dic.put(num,1);

                Integer minInx = dic.get(num-1);
                Integer maxInx = dic.get(num+1);

                if(minInx != null){
                    dic.put(num,minInx+1);
                    len = Math.max(dic.get(num),len);
                }

                if(maxInx != null){
                    dic.put(num+1,dic.get(num)+1);
                    len = Math.max(dic.get(num+1),len);
                }
            }
        }

        return len;
    }
}
