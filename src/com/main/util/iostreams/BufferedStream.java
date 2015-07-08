/**
 * 
 */
package com.main.util.iostreams;

/**
 * 
 *  Buffered input streams read data from a memory area known as a buffer; 
 *  the native input API is called only when the buffer is empty. 
 *  Similarly, buffered output streams write data to a buffer,
 *  and the native output API is called only when the buffer is full.
 *  
 *  There are four buffered stream classes used to wrap unbuffered streams:
 *  BufferedInputStream and BufferedOutputStream create buffered byte streams, 
 *  while BufferedReader and BufferedWriter create buffered character streams.
 *  
 *  Flushing Buffered Streams
 *  
 *  Some buffered output classes support auto-flush, specified by an optional constructor argument. 
 *  When auto-flush is enabled, certain key events cause the buffer to be flushed
 * @author Administrator
 *
 */
public class BufferedStream {

	/**
	 * 
	 */
	BufferedStream() {
		
	}
	
	
}
