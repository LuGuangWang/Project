package com.main.demo.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展单例模式，控制实际产生实例数目为 3 个
 * 如果你想要控制多个，可以利用 Map 来帮助缓存多个实例
 * @author 
 *
 */
public class Singleton {
	private final static String DEFAULT_PREKEY = "cache";// 为后面使用的 key 定义一个前缀
	private static Map<String, Singleton> map = new HashMap<String, Singleton>();// 定义缓存实例的容器
	private static int number = 1;// 定义初始化实例数目为 1
	private final static int NUM_MAX = 3;

	private Singleton() {

	}

	public static synchronized Singleton getInstance() {
		// 通过缓存理念及方式控制数量
		String key = DEFAULT_PREKEY + number;
		Singleton threeSingleton = map.get(key);
		if (threeSingleton == null) {
			threeSingleton = new Singleton();
			map.put(key, threeSingleton);
		}
		number++;// 实例数目加 1
		if (number > NUM_MAX) {
			number = 1;
		}
		return threeSingleton;
	}

	public static void main(String args[]) {
		Singleton t1 = getInstance();
		Singleton t2 = getInstance();
		Singleton t3 = getInstance();
		Singleton t4 = getInstance();
		Singleton t5 = getInstance();
		Singleton t6 = getInstance();
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
		System.out.println(t4.toString());
		System.out.println(t5.toString());
		System.out.println(t6.toString());
	}
}
