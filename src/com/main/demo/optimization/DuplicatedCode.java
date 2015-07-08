package com.main.demo.optimization;

/**
 * 代码的重复劳动由于计算机的高速运行，并不会对性能构成太大的威胁，
 * 但若希望将系统性能发挥到极致，还是有很多地方可以优化的
 * @author Administrator
 *
 */
public class DuplicatedCode {
	public static void beforeTuning() {
		long start = System.currentTimeMillis();
		double a1 = Math.random();
		double a2 = Math.random();
		double a3 = Math.random();
		double a4 = Math.random();
		double b1, b2;
		for (int i = 0; i < 10000000; i++) {
			b1 = a1 * a2 * a4 / 3 * 4 * a3 * a4;
			b2 = a1 * a2 * a3 / 3 * 4 * a3 * a4;
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void afterTuning() {
		long start = System.currentTimeMillis();
		double a1 = Math.random();
		double a2 = Math.random();
		double a3 = Math.random();
		double a4 = Math.random();
		double combine, b1, b2;
		for (int i = 0; i < 10000000; i++) {
			combine = a1 * a2 / 3 * 4 * a3 * a4;
			b1 = combine * a4;
			b2 = combine * a3;
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void main(String[] args) {
		DuplicatedCode.beforeTuning();
		DuplicatedCode.afterTuning();
	}
}
