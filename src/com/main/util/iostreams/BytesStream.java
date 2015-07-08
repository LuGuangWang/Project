/**
 * 
 */
package com.main.util.iostreams;

import java.io.*;

/**
 * Byte streams should only be used for the most primitive I/O.
 * @author Administrator
 *
 */
public class BytesStream {
	BytesStream(){
		
	}
	
	public static void CopyBytes(String primitiveFileName,String targetFileName) throws IOException{
		try(
				FileInputStream in = new FileInputStream(primitiveFileName);
				FileOutputStream  out = new FileOutputStream(targetFileName);
			){
			int c;
			while((c=in.read()) != -1){
				out.write(c);
			}
		}
	}
}
