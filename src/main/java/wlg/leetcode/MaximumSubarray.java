package wlg.leetcode;

public class MaximumSubarray {

  public static void main(String[] args) {
    MaximumSubarray m = new MaximumSubarray();
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    
    int sum = m.maxSubArray(nums);
    System.out.println(sum);
  }

  public int maxSubArray(int[] nums) {
    int i = 0,sum = nums[0],tmp = 0;
    while(i < nums.length){
      tmp += nums[i++];
      sum = sum<tmp?tmp:sum;
      if(tmp < 0){
        tmp = 0;
      }
    }
    
    return sum;
  }
}
