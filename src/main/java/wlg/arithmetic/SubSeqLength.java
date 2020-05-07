package wlg.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class SubSeqLength {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,3,4,6,7,8,9,5};

        int a = subSeqLength(nums);
        System.out.println(a);
    }

    public static int subSeqLength(int[] nums){
        int len = 0;
        if(nums != null && nums.length>0){
            Map<Integer,Integer> dic = new HashMap<>(nums.length);
            for(int num:nums){
                if(!dic.containsKey(num)){
                    dic.put(num,1);

                    Integer minInx = dic.get(num-1);
                    Integer maxInx = dic.get(num+1);

                    if(minInx != null){
                        len = Math.max(merge(dic,num-1,num),len);
                    }

                    if(maxInx != null){
                        len = Math.max(merge(dic,num,num+1),len);
                    }
                }
            }
        }

        return len;
    }

    private static int merge(Map<Integer,Integer> dic,int left,int right){
       int leftInx = left - dic.getOrDefault(left,0) + 1;
       int rightInx = right + dic.getOrDefault(right,0) - 1;

       int length = rightInx - leftInx + 1;

       dic.put(leftInx,length);
       dic.put(rightInx,length);

       return length;
    }
}
