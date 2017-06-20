package wlg.arithmetic;


/**
 * 河内之塔(Towers of Hanoi)是法国人M.Claus(Lucas)于1883年从泰国带至法国的，
 * 河内之塔为越战时北越的首都，即现在的胡志明市；
 * 1883年法国数学家Edouar Lucas曾提及这个故事 ，据说创世纪时Benares有一座波罗教塔，
 * 是由三支钻石棒所支撑，开始时神在第一根棒上放置64个由上至下依由小到大排列的金盘(Disc)，
 * 并命令僧侣将所有的金盘从第一根石棒移至第三根石棒，且搬运过程中遵守大盘子在小盘子之下的原则，
 * 若每日仅搬一个盘子，则当盘子全数搬运完毕之时，此塔将毁损，而也就是世界末日的来临之时
 * 
 * f(n) = 2^n - 1;
 */
public class TowerProblem {
  
  public static void main(String[] args) {
    TowerProblem p = new TowerProblem();
    int n = 4;
    int sum = p.tower(n);
    System.out.println("共需移动"+sum +"次"); 
    
    p.tower1(n);
  }

  /*
   * f(n) = 2 * f(n-1) + 1;
   */
  int tower(int n){
    if(n==1)
      return 1;
    else{
      return 2 * tower(--n) + 1;
    }
  }
  /**
   * f(n) = 2^n -1
   */
  void tower1(int n){
    int sum = (2<<(n-1)) - 1;
    System.out.println("共需移动"+sum +"次"); 
  }
}
