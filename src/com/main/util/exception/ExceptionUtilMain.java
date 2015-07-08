/**
 * 
 */
package com.main.util.exception;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

/**
 * @author Administrator
 *
 */
public class ExceptionUtilMain {

	private List<Integer> list;
    private static final int SIZE = 10;

    public ExceptionUtilMain () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

    // exception type: checked exception , unchecked exception , errors.
    public void writeList() {
        PrintWriter out = null;
		try {
			// The FileWriter constructor throws IOException, which must be caught. this is a checked exception
			out = new PrintWriter(new FileWriter("OutFile.txt"));

		    for (int i = 0; i < SIZE; i++) {
		        // The get(int) method throws IndexOutOfBoundsException, which must be caught. this is an unchecked exception
		        out.println("Value at: " + i + " = " + list.get(i));
		    }
		} catch (IOException | IndexOutOfBoundsException e) { // catch more than one type exception with one exception handler
			e.printStackTrace();
		}finally{// the perfect place to perform cleanup.
			if(out != null)
				out.close();
		}
    }
    
	//The try-with-resources statement is a try statement that declares one or more resources. 
    //A resource is an object that must be closed after the program is finished with it
	public static void writeToFileZipFileContents(String zipFileName,String outputFileName) throws IOException {
		Charset charset = StandardCharsets.US_ASCII;
		Path outputFilePath = Paths.get(outputFileName);
		// Open zip file and create output file with
		// try-with-resources statement can declares one or more resources
		try (ZipFile zf = new ZipFile(zipFileName);
				BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset)
			) {
			// Enumerate each entry
			for (Enumeration<?> entries = zf.entries(); 
				 entries.hasMoreElements();) {
				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		}
	}
    
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExceptionUtilMain exMain = new ExceptionUtilMain();
		exMain.writeList();
		
		try {
			writeToFileZipFileContents("test.zip","test.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
