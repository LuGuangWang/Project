package wlg.apiutil.httputil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class HttpClient {
	private String baseUrl;

	public HttpClient(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public int post(String url, String postData) throws IOException {
		if (!baseUrl.isEmpty())
			url = baseUrl.concat(url);

		HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();

		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		connection.setDoOutput(true);
		connection.setConnectTimeout(3000);
		connection.setReadTimeout(3000);

		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("User-Agent", "es-client");
		connection.setRequestProperty("Connection", "Keep-Alive");

		byte[] data = postData.getBytes();
		int length = data.length;
		connection.setRequestProperty("Content-Length", Integer.toString(length));

		try (OutputStream post = connection.getOutputStream()) {
			post.write(data, 0, length);
		}
		
		connection.disconnect();
		
		int statecode = connection.getResponseCode();

		return statecode;
	}
	
	public static void main(String[] args) {
		SecurityManager sm = System.getSecurityManager();
		
		
		for(int i = 0;i<200;i++){
			HttpClient client = new HttpClient("http://localhost:8080");
			try {
				client.post("/test2", "{\"m\":1}");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		CountDownLatch lock = new CountDownLatch(1);
		try {
			lock.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
