package wlg.apiutil.httputil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
	private String baseUrl;

	public HttpClient(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public int post(String url, String postData) throws IOException {
		if (!baseUrl.isEmpty())
			url = baseUrl.concat(url);

		HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();

		connection.setRequestMethod("POST");
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

}
