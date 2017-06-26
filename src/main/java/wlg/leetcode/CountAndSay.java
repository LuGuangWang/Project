package wlg.leetcode;

public class CountAndSay {

  public static void main(String[] args) {
    CountAndSay c = new CountAndSay();
    String result = c.countAndSay(5);
    System.out.print("result:" + result);
  }

  public String countAndSay(int n) {
    String result = "1",str = "";
    int index = 2;
    while(index <= n){
      str = "";
      char[] eles = result.toCharArray();
      int count = 1;
      char tmp = eles[0];
      for(int i = 1;i<eles.length;i++){
       if(eles[i] == tmp){
         count ++;
       }else{
         str += ""+count+tmp;
         count = 1;
         tmp = eles[i];
       }
      }
      str += ""+count+tmp;
      result = str;
      index ++;
    }
    
    return result;
  }
}
