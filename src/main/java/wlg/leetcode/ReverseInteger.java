package wlg.leetcode;

public class ReverseInteger {

  public static void main(String[] args) {
    ReverseInteger in = new ReverseInteger();
    int result = in.reverse(153234342);
    System.out.println(result);
  }
  
  public int reverse(int x) {
    int result = 0,newResult=0;
    while(x!=0){
      int tail = x % 10;
      newResult = result * 10 + tail;
      if((newResult-tail)/10 != result){
        return 0;
      }else{
        result = newResult;
      }
      x = x/10;
    }
    return result;
  }
}
