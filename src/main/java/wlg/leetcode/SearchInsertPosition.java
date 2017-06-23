package wlg.leetcode;

public class SearchInsertPosition {

  public static void main(String[] args) {
    SearchInsertPosition p = new SearchInsertPosition();
    int[] nums = {1};
    int target = 1;
    int index = p.searchInsert(nums, target);
    System.out.print(index);
  }
  
  public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length - 1,mid = 0;
   
    while(low < high){
      mid = (high+low) >> 1;
      if(nums[mid] == target){
        return mid;
      }else if(nums[mid] < target){
        low = mid + 1;
      }else{
        high = mid - 1;
      }
    }
    
    return nums[low]<target?low+1:low;
  }
}
