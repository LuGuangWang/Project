package wlg.leetcode;

public class AddBinary {

  public static void main(String[] args) {
    
    AddBinary a = new AddBinary();
    String result = a.addBinary("1010", "1011");
    System.out.print(result);
  }

  public String addBinary(String a, String b) {
    int alen = a.length(),blen = b.length(),flag=0,max=alen>blen?alen:blen;
    
    char[] normal = new char[max],over = new char[max+1];
    over[0] = '1';
    for(int i = max - 1;i>=0;i--){
      char ac = alen>0?a.charAt(--alen):'0';
      char bc = blen>0?b.charAt(--blen):'0';
      
      int sum = ac + bc + flag;
      
      flag = sum / 2 - '0';
      normal[i] = (char) (sum % 2 + '0');
      over[i+1] = normal[i];
    }
    return flag == 1?new String(over):new String(normal);
  }
}
