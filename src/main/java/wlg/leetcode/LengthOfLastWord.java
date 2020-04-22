package wlg.leetcode;

public class LengthOfLastWord {

  public static void main(String[] args) {
    String str = "Hello  world ";
    LengthOfLastWord l = new LengthOfLastWord();
    int result = l.lengthOfLastWord(str);
    System.out.print(result);
  }
  
  public int lengthOfLastWord(String s) {
    char[] eles = s.toCharArray();
    char flag1 = ' ';
    int cnt = 0;

    for(int i = eles.length - 1;i>=0;i--){
      if(eles[i] != flag1){
        cnt++;
      }else if(cnt>0){
        break;
      }
    }
    
    return cnt;
  }
}
