package wlg.arithmetic;

/**
 * 
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 
 * [解析] 典型的 hash 应用，当知道有限范围时可以自己定义数组当作 hash 表。 这里字符串由字母组成，因此只需要 ascii 码的长度即可满足。
 * 当额外空间为一个较小的固定常数时可认为是常数空间的开销。
 * 
 * 字符（char）是一个长度为8的数据类型，因此总共有256种可能
 * 
 * @author seven
 *
 */
public class FindFirstLetter {
	
	private static int findFirstLetter(String str) {
		int index = -1;
		int size = 2 << 7;
		int[] hash = new int[size];
		
		if(str != null) {
			for(int i=0;i<str.length();i++) {
				hash[str.charAt(i)]++;
			}
			
			for(int i=0;i<str.length();i++) {
				if(hash[str.charAt(i)]==1) {
					index = i;
					break;
				}
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaacb";
		int index = findFirstLetter(str);
		System.out.println(index);
	}
}
