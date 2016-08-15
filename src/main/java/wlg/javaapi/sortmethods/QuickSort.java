package wlg.javaapi.sortmethods;

/**
 * 快速排序
 */
public class QuickSort {
  
  /**
   * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
   * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
   * 
   * 快速排序是一种不稳定的排序算法
   * 
   * 快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的
   * 
   * 通常以“三者取中法”来选取基准记录
   */
  static void quickSort(int[] a,int low,int high){
    int middle = getMiddle(a, low, high);
    if(middle-1>low)
      quickSort(a, low, middle-1);
    if(middle+1<high)
      quickSort(a, middle+1, high);
  }

  /**
   * 按照基数分割
   */
  private static int getMiddle(int[] a, int low, int high) {
    int baseKey = a[low],tmp;
    while(low < high){
      while(low<high && a[high] >= baseKey){
        high--;
      }
      
      if(low!=high){
        tmp = a[low];
        a[low] = a[high];
        a[high] = tmp;
        low ++;
      }else{
        break;
      }
      
      while(low<high && a[low] <= baseKey){
        low ++;
      }
      if(low!=high){
        tmp = a[low];
        a[low] = a[high];
        a[high] = tmp;
      }
    }
    
    return low;
  }

  public static void main(String[] args) {
    int a[] = {3,1,5,7,2,4,9,6,10,8};  
    quickSort(a, 0, a.length-1);
    for(int t:a){
      System.out.print("\t"+t);
    }
  }

}
