package wlg.arithmetic;

/**
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 */
public class RabbitProblem {
  
  public static void main(String[] args) {
    RabbitProblem instance = new RabbitProblem();
    instance.fetchRabbits(1,0,0,1);
    System.out.println("====================");
    int sum = instance.fetchRabbits(12);
    System.out.println("12月，兔子总数：" + sum);
  }
  /**
   * f(1) = 1;
   * f(2) = 1;
   * f(x) = f(x-1) +　f(x-2)
   */
  public int fetchRabbits(int month){
    if(month < 0){
      throw new Error("month can't less than zero.");
    }
    
    if(month <= 2){
      return 1;
    }else{
      return fetchRabbits(month-1) + fetchRabbits(month-2);
    }
    
  }
  
  public void fetchRabbits(int month,int old,int mid,int child){
    int sum = old + mid + child;
    System.out.println(month+"月，兔子总数：" + sum);
    
    old = old + mid;
    mid = child;
    child = old;
    
    if(month<13){
      fetchRabbits(++month,old,mid,child);
    }
  }
  
  
}
