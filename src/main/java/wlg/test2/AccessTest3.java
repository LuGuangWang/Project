package wlg.test2;

import wlg.test.AcessTest1;

public class AccessTest3 extends AcessTest1{

  
  void test3(){
    test1();
  }
  
  public static void main(String[] args) {
//    operateChar();
//    System.out.println("2.00".replaceAll("\\.0+$", ""));
//    System.out.println(lengthOfLongestSubstring("ckilbkd"));
//    System.out.println(lengthOfLongestSubstring("abba"));
    
//    int[] nums1 = {2};
//    int[] nums2 = {1,3,4,5};
//    double mid = findMedianSortedArrays(nums1,nums2);
//    System.out.println(mid);
    
    String s = "non";
    System.out.println(s.replace("a", "")=="");
    System.out.println(getPalindromeLength(s));
    System.out.println(getPalindrome(s));
  }

  static String getPalindrome(String s){
    if (s == null) {
      return s;
    }
    int len = s.length()*2+1;
    StringBuilder newStr = new StringBuilder(len);
    newStr.append('#');
    for (int i = 0; i < s.length(); i++) {
      newStr.append(s.charAt(i));
      newStr.append('#');
    }
    int center = 0, right = 0, r, maxR = 0, index = 0,beginIndex,endIndex,ri,li;
    int p[] = new int[len];
    for (int i = 1; i < len - 1; i++) {
      r = right > i ? Math.min(p[center + center - i], right - i) : 0;
      li = i - r - 1;
      ri = i + r + 1 ;
      while (li >= 0 && ri < len
             && newStr.charAt(li) == newStr.charAt(ri)) {
        r++;
        li--;
        ri++;
      }
      if (i + r > right) {
        right = i + r;
        center = i;
        if (r > maxR) {
          maxR = r;
          index = i;
        }
      }
      p[i] = r;
      
    }
    beginIndex = (index - maxR) / 2;
    endIndex = (index + maxR) / 2;
    return s.substring(beginIndex, endIndex);
  }
  
  
  public static int getPalindromeLength(String str) {
    // 1.构造新的字符串
    // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
    StringBuilder newStr = new StringBuilder();
    newStr.append('#');
    for (int i = 0; i < str.length(); i++) {
      newStr.append(str.charAt(i));
      newStr.append('#');
    }
    // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
    int[] rad = new int[newStr.length()];
    // right表示已知的回文中，最右的边界的坐标
    int right = 0;
    // id表示已知的回文中，拥有最右边界的回文的中点坐标
    int id = 0;
    // 2.计算所有的rad
    // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
    for (int i = 1; i < newStr.length()-1; i++) {
      // 2.1.确定一个最小的半径
      int r = 1;
      if (i <= right) {
        r = Math.min(rad[id] - i + id, rad[2 * id - i]);
      }

      // 2.2.尝试更大的半径
      while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r) == newStr.charAt(i + r)) {
        r++;
      }

      // 2.3.更新边界和回文中心坐标
      if (i + r - 1 > right) {
        right = i + r - 1;
        id = i;

      }
      rad[i] = r;
    }

    // 3.扫描一遍rad数组，找出最大的半径
    int maxLength = 0;
    for (int r : rad) {
      if (r > maxLength) {
        maxLength = r;
      }
    }
    return maxLength - 1;
  }
  
  static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double median = 0.0;
    
    return median;
  }

   
  static int lengthOfLongestSubstring(String s) {
    int len=0, tlen =0,index=0;
    if(s!=null && s.length()>0){
      int[] indexs = new int[s.length()];
      for(int i = 0;i<s.length();i++){
        index = (s.length()-1) & hash(s.charAt(i));
        tlen = Math.max(indexs[index], i);
        len = Math.max(len, tlen - i + 1);
        indexs[index] = i+1;
      }
    }
    return len;
  }
  
  static int hash(Object key) {
    int h;
    return (h = key.hashCode()) ^ (h >>> 16);
  }

  
  static void operateChar() {
    String a = "1";
    String b = "2";
    int c = a.charAt(0) + b.charAt(0) - '0' - '0';
    System.out.println(c);
  }

}
