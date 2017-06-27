package wlg.leetcode;

public class LengthOfLastWord {

  public static void main(String[] args) {
    String str = "Hello  world ";
    LengthOfLastWord l = new LengthOfLastWord();
    int result = l.lengthOfLastWord(str);
    System.out.print(result);
  }
  
  public int lengthOfLastWord(String s) {
    s = s.trim();
    char[] eles = s.toCharArray();
    int result = eles.length;
    
    for(int i = eles.length - 1;i>=0;i--){
      if(eles[i] == ' '){
        result = eles.length - 1 - i;
        break;
      }
    }
    
    return result;
  }
}
