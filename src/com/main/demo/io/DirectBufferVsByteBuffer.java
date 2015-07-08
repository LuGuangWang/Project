package com.main.demo.io;

import java.nio.ByteBuffer;

/**
 * NIO 的 Buffer 还提供了一个可以直接访问系统物理内存的类 DirectBuffer。DirectBuffer 继承自
 * ByteBuffer，但和普通的 ByteBuffer 不同。普通的 ByteBuffer 仍然在 JVM 堆上分配空间，其最大内存受到最大堆的限制，而
 * DirectBuffer 直接分配在物理内存上，并不占用堆空间。在对普通的 ByteBuffer
 * 访问时，系统总是会使用一个“内核缓冲区”进行间接的操作。而 DirectrBuffer 所处的位置，相当于这个“内核缓冲区”。因此，使用
 * DirectBuffer 是一种更加接近系统底层的方法，所以，它的速度比普通的 ByteBuffer 更快。DirectBuffer 相对于
 * ByteBuffer 而言，读写访问速度快很多，但是创建和销毁 DirectrBuffer 的花费却比 ByteBuffer 高。DirectBuffer
 * 与 ByteBuffer 相比较的代码
 * 
 * 由于创建和销毁 DirectBuffer 的代码比较高昂，不宜使用 DirectBuffer。但是如果能将 DirectBuffer
 * 进行复用，可以大幅改善系统性能。
 * 
 * 由于 NIO 使用起来较为困难，所以许多公司推出了自己封装 JDK NIO 的框架，例如 Apache 的 Mina，JBoss 的 Netty，Sun
 * 的 Grizzly 等等，这些框架都直接封装了传输层的 TCP 或 UDP 协议，其中 Netty 只是一个 NIO 框架，它不需要 Web
 * 容器的额外支持，也就是说不限定 Web 容器。
 * 
 * @author Administrator
 *
 */
public class DirectBufferVsByteBuffer {
	public void DirectBufferPerform() {
		long start = System.currentTimeMillis();
		ByteBuffer bb = ByteBuffer.allocateDirect(500);// 分配 DirectBuffer
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 99; j++) {
				bb.putInt(j);
			}
			bb.flip();
			for (int j = 0; j < 99; j++) {
				bb.getInt(j);
			}
		}
		bb.clear();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			ByteBuffer b = ByteBuffer.allocateDirect(10000);// 创建 DirectBuffer
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public void ByteBufferPerform() {
		long start = System.currentTimeMillis();
		ByteBuffer bb = ByteBuffer.allocate(500);// 分配 DirectBuffer
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 99; j++) {
				bb.putInt(j);
			}
			bb.flip();
			for (int j = 0; j < 99; j++) {
				bb.getInt(j);
			}
		}
		bb.clear();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			ByteBuffer b = ByteBuffer.allocate(10000);// 创建 ByteBuffer
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void main(String[] args) {
		DirectBufferVsByteBuffer db = new DirectBufferVsByteBuffer();
		db.ByteBufferPerform();
		db.DirectBufferPerform();
	}
}
