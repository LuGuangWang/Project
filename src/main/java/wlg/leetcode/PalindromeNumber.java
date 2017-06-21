package wlg.leetcode;

public class PalindromeNumber {

  public static void main(String[] args) {
    PalindromeNumber p = new PalindromeNumber();
    boolean result = p.isPalindrome(11);
    System.out.println(result);
  }
  
  public boolean isPalindrome(int x) {
    // 因为算法已经cover了10,20,30,...有尾巴一串0的corner case，所以这里不用判断
    if (x < 0) {
        return false;
    }
    int tempX = x;
    int reverse = 0;
    // 当tempX剩下一位数的时候停下来
    while (tempX >= 10) {
        reverse = reverse * 10 + tempX % 10;
        tempX /= 10;
    }
    //对比整个x的头尾两位，以及中间所有位reverse以后是否与不reverser时一致
    return tempX == x % 10 && reverse == x / 10;
  }
}
