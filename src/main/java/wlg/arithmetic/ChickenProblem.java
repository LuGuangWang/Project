package wlg.arithmetic;
/**
 * 公鸡5文钱一只，母鸡3文钱一只，小鸡3只一文钱，用100文钱买一百只鸡,
 * 其中公鸡，母鸡，小鸡都必须要有，问公鸡，母鸡，小鸡要买多少只刚好凑足100文钱。
 */
public class ChickenProblem {

  public static void main(String[] args) {
    ChickenProblem instance = new ChickenProblem();
    instance.calc();
  }
  /**
   * x:公鸡，y:母鸡，z:小鸡
   * 推导出公式：
   * 7x+4y=100  ==> y = 25-7x/4
   * x+y+z=100
   * 假设：x = 4k; ==> y=25-7k; z=75+3k ==> 0<k<=3
   */
  public void calc(){
    for(int k = 1;k<=3;k++){
      System.out.println("公鸡："+(4*k) + " 母鸡："+(25-7*k) + " 小鸡："+ (75+3*k));
    }
  }
  
  
}
