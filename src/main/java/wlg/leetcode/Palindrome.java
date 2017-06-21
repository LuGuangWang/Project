package wlg.leetcode;

/**
 * 给定一个字符串，求它的最长回文子串长度。
 * 如果一个字符串正着读和反着读是一样的，那它就是回文串。
 * 回文串的实例： 12321 a aba abba aaaa tattarrattat
 */
public class Palindrome {
  private int lo, maxLen;
  
  public static void main(String[] args) {
    Palindrome instance = new Palindrome();
    String result = instance.longestPalindrome("aaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaa");
    
    System.out.println(result);
  }
  
  private String longestPalindrome(String s) {
    if(s == null || s.length()<2){
      return s;
    }
    for(int i = 0;i<s.length()-1;i++){
      extendPalindrome(s, i, i);//中心开花，遍历奇数
      extendPalindrome(s,i,i+1);//中心开花，遍历偶数
    }
    return s.substring(lo,lo + maxLen);
  }

  private void extendPalindrome(String s, int low, int high) {
    while(low >=0 && high<s.length() && s.charAt(low) == s.charAt(high)){
      low--;
      high++;
    }
    if(maxLen < high-low - 1){
      maxLen = high-low - 1;
      lo = low + 1;
    }
  }
}
