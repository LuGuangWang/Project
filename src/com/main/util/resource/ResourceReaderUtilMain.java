/**
 * 
 */
package com.main.util.resource;

import java.io.*;
import java.net.*;

/**
 * @author Administrator
 *
 */
public class ResourceReaderUtilMain {

	/**
	 * 
	 */
	public ResourceReaderUtilMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取资源文件的路径
	 * @param filePath
	 * @throws IOException
	 */
	public void readerResourceURL(String filePath) throws IOException{
		URL url = getClass().getResource(filePath);
		System.out.println(url.getPath());
	}
	
	/**
	 * 获取资源的里的数据
	 * @throws IOException
	 */
	public void readerResources(String filePath) throws IOException{
		InputStream input = getClass().getResourceAsStream(filePath);
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader bufReader = new BufferedReader(reader);
		String content = bufReader.readLine();
		while(content != null){
			System.out.println(content);
			content = bufReader.readLine();
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ResourceReaderUtilMain instance = new ResourceReaderUtilMain();
		instance.readerResources("/json/parameters_create.json");
		
		instance.readerResourceURL("/json/parameters_create.json");
	}

}
