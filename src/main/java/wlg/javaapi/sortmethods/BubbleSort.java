package wlg.javaapi.sortmethods;
/**
 * 冒泡排序
 */
public class BubbleSort {

  /**
   * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
   * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
   * 
   * 时间复杂度为O(n^2)
   * 
   * 冒泡排序是一种稳定排序算法
   */
  static void bubbleSort(int[] a){
    int tmp = 0;
    for(int i=0;i<a.length;i++)
      for(int j=i+1;j<a.length;j++)
        if(a[i]>a[j]){
          tmp =  a[i];
          a[i] = a[j];
          a[j]=tmp;
        }
  }
  
  public static void main(String[] args) {
    int[] a = {20, 40, 60, 80, 30, 70, 90, 10, 50, 0};
    bubbleSort(a);
    for(int t:a){
      System.out.print("\t"+t);
    }
  }

}
