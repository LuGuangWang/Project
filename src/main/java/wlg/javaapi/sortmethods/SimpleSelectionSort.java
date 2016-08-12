package wlg.javaapi.sortmethods;

/**
 * 简单选择排序
 */
public class SimpleSelectionSort {

  /**
   * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换； 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，
   * 直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
   * 
   * 简单选择排序是不稳定排序。
   * 
   * 时间复杂度为O(n^2)
   */
  static void simpleSelectionSort(int[] a) {
    int minIndex,min;
    for (int i = 0; i < a.length; i++) {
      minIndex = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] < a[minIndex]) {
          minIndex = j;
        }
      }
      if(i!=minIndex){
        min = a[minIndex];
        a[minIndex] = a[i];
        a[i] = min;
      }
    }
  }

  
  public static void main(String[] args) {
    int[] a = {4, 9, 23, 1, 45, 27, 5, 2};
    simpleSelectionSort(a);
    for(int t:a){
      System.out.print("\t"+t);
    }
  }

}
