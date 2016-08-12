package wlg.javaapi.sortmethods;

/**
 * 希尔排序又叫缩小增量排序
 */
public class ShellSort {
  /**
   * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序， 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
   * 
   * 一般的初次取序列的一半为增量，以后每次减半，直到增量为1。
   */
  static void shellSort(int[] a) {
    for(int gap = a.length/2;gap>=1;gap/=2){//获取增量
      straitInsertSort(a, gap);
    }
  }


  /**
   * 直接插入排序
   */
  private static void straitInsertSort(int[] a, int gap) {
    int tmp;
    int insertIndex;
    for(int i = gap;i<a.length;i++){
      tmp = a[i];
      insertIndex = i;
      while(tmp<a[insertIndex-1]){
        a[insertIndex] = a[insertIndex-1];
        insertIndex -- ;
        if(insertIndex==0){
          break;
        }
      }
      a[insertIndex] = tmp;
    }
  }


  public static void main(String[] args) {
    int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
    shellSort(a);
    for(int t:a){
      System.out.print("\t"+t);
    }
  }

}
