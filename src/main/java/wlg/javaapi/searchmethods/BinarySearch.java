package wlg.javaapi.searchmethods;
/**
 * 二分查找
 */
public class BinarySearch {

  /**
   * 二分查找又称折半查找，优点是比较次数少，查找速度快，平均性能好；其缺点是要求待查表为有序表，且插入删除困难。
   * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
   * 
   * 时间复杂度是O(logN)
   */
  static void binarySearch(int[] a,int searchValue){
    int low = 0,high = a.length-1,middle,count=1;
    while(low<=high){
      System.out.println("circle count:" + count++);
      middle = (low + high) >> 1;
      if(a[middle] == searchValue){
        System. out.println( "查到了您想要的结果" + searchValue + "，位置在：" + middle);
        break;
      }else if(a[middle]< searchValue){
        low = middle + 1;
      }else{
        high = middle -1;
      }
    }
  }
  
  static void binarySearch(int[] a,int low,int high,int searchValue){
    int middle = (low+high)>>1;
    if(a[middle] == searchValue){
      System. out.println( "递归查到了您想要的结果" + searchValue + "，位置在：" + middle);
      low = middle + 1;
    }else if(a[middle]< searchValue){
      low = middle + 1;
    }else{
      high = middle -1;
    }
    if(low<=high){
      binarySearch(a, low,high,searchValue);
    }else{
      System. out.println( "没有您想要的结果.");
    }
    
  }
  
  public static void main(String[] args) {
    int[] a = {1,2,3,4,5,5,6,7,8,9};
    
//    binarySearch(a, 0, a.length-1,5);
    
    binarySearch(a, 5);
  }

}
