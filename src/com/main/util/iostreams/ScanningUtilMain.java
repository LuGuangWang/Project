package com.main.util.iostreams;

import java.io.*;
import java.util.*;
/**
 * 
 * Objects of type Scanner are useful for breaking down formatted input into
 * tokens and translating individual tokens according to their data type.
 * 
 * @author Administrator
 *
 */
public class ScanningUtilMain {

	/**
	 * 
	 */
	public ScanningUtilMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static void scannerNumber(String fileName){
		double sum = 0;
		try (Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)))){
            s.useLocale(Locale.US);
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }   
            }
        }catch(IOException e){
        	e.printStackTrace();
        }
		System.out.println(sum);
	}

	public static void main(String[] args){
		scannerNumber("scanning-test.txt");
	}
}
