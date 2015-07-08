/**
 * 
 */
package com.main.util.iostreams;

import java.io.*;

/**
 * @author Administrator
 *
 */
public class CharacterStream {
	CharacterStream(){
		
	}
	// in CopyCharacters, the int variable holds a character value in its last 16 bits; 
	//in CopyBytes, the int variable holds a byte value in its last 8 bits.
	public static void CopyCharacters(String primitiveFileName,String targetFileName) throws IOException{
		try(
				FileReader in = new FileReader(primitiveFileName);
				FileWriter  out = new FileWriter(targetFileName);
			){
			int c;
			while((c=in.read()) != -1){
				out.write(c);
			}
		}
	}
}
