package wlg.arithmetic;

/**
 * 最大连续子序列和
 *
 * f(i) = max(a[i],f(i-1)+a[i])
 */
public class SubSeqSum {

    public static void main(String[] args) {
        int[] nums = {-2,11,-4,13,-5,-2};

        long res = subSeqSum(nums);

        System.out.println(res);
    }

    public static long subSeqSum(int[] nums){
        long res = nums[0];

        long[] ress = new long[nums.length];
        ress[0] = nums[0];

        for(int i = 1;i<nums.length;i++){
            ress[i] = Math.max(nums[i],ress[i-1]+nums[i]);

            res = Math.max(res,ress[i]);
        }

        return res;
    }
}
