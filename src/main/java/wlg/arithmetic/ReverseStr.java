package wlg.arithmetic;
/**
 * 左旋转字符串
 * 大致思路：
 * （1）先将左边 3 个字符串进行翻转：abcXYZdef --> cbaXYZdef
 * （2）再将右边剩余字符串进行翻转：cbaXYZdef --> cbafedZYX
 * （3）最后将整个字符串进行翻转： cbafedZYX --> XYZdefabc
 * @author seven
 *
 */
public class ReverseStr {

	public static String reverse(String str) {
		char[] cs = str.toCharArray();
		int k = 3,len = cs.length - 1, l = len + k;
		char tmp;
		
		for(int i = 0;i<=k/2;i++) {
			tmp = cs[i];
			cs[i] = cs[k-1-i];
			cs[k-1-i]=tmp;
		}
		
		for(int i = k;i<=l/2;i++) {
			tmp = cs[i];
			cs[i] = cs[l-i];
			cs[l-i] = tmp;
		}
		
		for(int i = 0;i<=len/2;i++) {
			tmp = cs[i];
			cs[i] = cs[len-i];
			cs[len-i] = tmp;
		}
		
		return new String(cs);
	}
	
	public static void main(String[] args) {
		String str = "abcXYZdef";
		
		String res = reverse(str);
		System.out.println(res);
	}
}
