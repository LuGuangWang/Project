/**
 * 
 */
package com.main.util.iostreams;

import java.io.*;

/**
 * @author Administrator
 *
 */
public class IOFromUtilMain {

	/**
	 * 
	 */
	public IOFromUtilMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStreamReader  cin = new InputStreamReader(System.in);
		try {
			System.out.println("cin:"+cin.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedInputStream bufIn = new BufferedInputStream(System.in);
		try {
			System.out.println("bufIn:"+bufIn.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("stdin:"+stdin.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Console c = System.console();
		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		String login = c.readLine("Enter your login: ");
		System.out.println("Enter your login:" + login);
	}

}
