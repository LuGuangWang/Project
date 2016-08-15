package wlg.javaapi.searchmethods;
/**
 * 顺序查找
 */
public class OrderSearch {

  /**
   * 一个一个的查
   * 
   * 时间复杂度是O(n)
   */
  static void orderSearch(int[] a,int searchValue){
    for(int i=0;i<a.length;i++){
      if(searchValue==a[i]){
        System. out.println( "查到了您想要的结果" + searchValue + "，位置在：" + i);
      }
    }
      
  }
  
  public static void main(String[] args) {
    int[] a=new int[]{2,3,5,6,7,3,};
    orderSearch(a, 3);
  }

}
