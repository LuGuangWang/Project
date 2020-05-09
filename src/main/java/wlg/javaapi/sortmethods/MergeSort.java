package wlg.javaapi.sortmethods;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3,2,2,1,5,6,7,9,10,8,4};
        int[] res = mergeSort(nums,0,nums.length-1);
        for(int num:res){
            System.out.print(num+ " ");
        }
    }

    private static int[] mergeSort(int[] nums,int low,int high){
        if(low==high){
            return new int[]{nums[low]};
        }

        int mid = low + (high-low)/2;

        int[] leftNums = mergeSort(nums,low,mid);
        int[] rightNums = mergeSort(nums,mid+1,high);


        return mergeNums(leftNums,rightNums);

    }

    private static int[] mergeNums(int[] leftNums,int[] rightNums){
        int lInx = 0,rInx = 0;
        int[] res = new int[leftNums.length+rightNums.length];
        int resInx = 0;
        while(lInx<leftNums.length && rInx<rightNums.length){
            if(leftNums[lInx]<rightNums[rInx]){
                res[resInx++] = leftNums[lInx++];
            }else{
                res[resInx++] = rightNums[rInx++];
            }
        }
        while (lInx<leftNums.length){
            res[resInx++] = leftNums[lInx++];
        }
        while (rInx<rightNums.length){
            res[resInx++] = rightNums[rInx++];
        }
        return res;
    }
}
