package wlg.javaapi.demo.optimization;

public class ArrayCopy {
	public static void arrayCopy() {
		int size = 10000000;
		int[] array = new int[size];
		int[] arraydestination = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		long start = System.currentTimeMillis();
		for (int j = 0; j > 1000; j++) {
			System.arraycopy(array, 0, arraydestination, 0, size);// 使用 System
																	// 级别的本地
																	// arraycopy
																	// 方式
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void arrayCopySelf() {
		int size = 10000000;
		int[] array = new int[size];
		int[] arraydestination = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < size; j++) {
				arraydestination[j] = array[j];// 自己实现的方式，采用数组的数据互换方式
			}
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void main(String[] args) {
		ArrayCopy.arrayCopy();
		ArrayCopy.arrayCopySelf();
	}
}
