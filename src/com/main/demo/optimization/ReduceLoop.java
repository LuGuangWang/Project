package com.main.demo.optimization;

/**
 * 当性能问题成为系统的主要矛盾时，可以尝试优化循环，例如减少循环次数，这样也许可以加快程序运行速度。
 * @author Administrator
 *
 */
public class ReduceLoop {
	public static void beforeTuning() {
		long start = System.currentTimeMillis();
		int[] array = new int[9999999];
		for (int i = 0; i < 9999999; i++) {
			array[i] = i;
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void afterTuning() {
		long start = System.currentTimeMillis();
		int[] array = new int[9999999];
		for (int i = 0; i < 9999999; i += 3) {
			array[i] = i;
			array[i + 1] = i + 1;
			array[i + 2] = i + 2;
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void main(String[] args) {
		ReduceLoop.beforeTuning();
		ReduceLoop.afterTuning();
	}
}
