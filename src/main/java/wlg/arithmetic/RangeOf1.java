package wlg.arithmetic;

/**
 * [整数中1出现的次数（从1到n的整数中1出现的次数）] 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * 
 * @author seven
 *
 */
public class RangeOf1 {

	public int countDigitOne(int n) {
		int count = 0;
		long a, b;
		for (long m = 1; m <= n; m *= 10) {
			a = n / m;
			b = n % m;
			count += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
		}
		return count;
	}

	public static void main(String[] args) {
		RangeOf1 r = new RangeOf1();
		int res = r.countDigitOne(13);
		System.out.println(res);
	}
}
