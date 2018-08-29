package wlg.apiutil.httputil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
  public static String doPost(String url, Map<String, String> params) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(url);
    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    for (String name : params.keySet()) {
      nvps.add(new BasicNameValuePair(name, params.get(name)));
    }
    System.out.println("requst param:" + nvps);
    CloseableHttpResponse response2 = null;
    try {
      httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
      response2 = httpclient.execute(httpPost);
      System.out.println("response status:"+response2.getStatusLine());
      HttpEntity entity2 = response2.getEntity();
      // do something useful with the response body
      // and ensure it is fully consumed
      String response = EntityUtils.toString(entity2);
      return response;
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      IOUtils.closeQuietly(response2);
    }
  }
  
  public static void main(String[] args) throws Exception {
	  String url="http://localhost:8080/test2";
	  HttpPost post = new HttpPost(url);
	  post.setHeader("Accept-Charset", "UTF-8");
	  
	  MultipartEntity entity = new MultipartEntity();
      entity.addPart("m", new StringBody("1"));
      entity.addPart("name", new StringBody("2"));
	  post.setEntity(entity);
	  
	  CloseableHttpClient httpclient = HttpClients.createDefault();
	  httpclient.execute(post);
  }
}
