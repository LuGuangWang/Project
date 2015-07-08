/**
 * 
 */
package com.main.util.iostreams;

/**
 * @author Administrator
 *
 */
public class FormattingUtilMain {

	/**
	 * 
	 */
	public FormattingUtilMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int i = 2;
		double r = Math.sqrt(i);
		/**
		 * d formats an integer value as a decimal value. 
		 * f formats a floating point value as a decimal value. 
		 * n outputs a platform-specific line terminator.
		 */
		System.out.format("The square root of %d is %f.%n", i, r);
	}
}
