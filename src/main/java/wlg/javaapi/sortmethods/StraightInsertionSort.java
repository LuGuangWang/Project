package wlg.javaapi.sortmethods;
/**
 * 直接插入排序
 */
public class StraightInsertionSort {

  /**
   * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
   * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
   * 
   * 要点：设立哨兵，作为临时存储和判断数组边界之用。
   * 
   * 插入排序是稳定的
   * 
   * 时间复杂度：O（n^2）.
   */
  private static void insertSort(int a[]){
    int tmp = 0;
    int insertIndex = 0;
    for(int i=1;i<a.length;i++){
      insertIndex = i;
      tmp = a[i];
      while(tmp<a[insertIndex-1]){
        a[insertIndex] = a[insertIndex-1];
        insertIndex--;
        if(insertIndex==0){
          break;
        }
      }
      a[insertIndex] = tmp;
    }
  }
  
  public static void main(String[] args) {
    int a[] = {3,1,5,7,2,4,9,6};
    insertSort(a);
    for(int t:a){
      System.out.print("\t"+t);
    }
  }

}
