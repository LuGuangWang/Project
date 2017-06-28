package wlg.leetcode;

public class PlusOne {

  public static void main(String[] args) {
    PlusOne p = new PlusOne();
    int[] digits ={9,49};
    int[] result = p.plusOne(digits);
    for(int i:result){
      System.out.print(i + " ");
    }
  }
  
  public int[] plusOne(int[] digits) {
    int[] result = null,normal = new int[digits.length],over = new int[digits.length + 1];
    int flag = 1,sum = 0;
    for(int i = digits.length-1;i>=0;i--){
      sum = digits[i] + flag;
      flag = sum / 10;
      normal[i] = sum % 10;
      over[i+1] = normal[i];
    }
    if(flag == 1){
      over[0] = 1;
      result = over;
    }else{
      result = normal;
    }
    return result;
  }
}
