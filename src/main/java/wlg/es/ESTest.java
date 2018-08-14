package wlg.es;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.alibaba.fastjson.JSONObject;

public class ESTest {
	
	
	public void testGet() {
		
		TransportClient client = null;
		try {
			int count = Runtime.getRuntime().availableProcessors();
			System.out.println("=== count :" + count);
			
			Settings settings = Settings.builder()
					.put("cluster.name", "my-application")
					.put("client.transport.sniff", false).build();
			client = new PreBuiltTransportClient(settings);
			client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
			
//			
			Msg m1 = new Msg();
			m1.setName("sss");
			
			JSONObject m2 = new JSONObject();
			m2.put("as1", "va1");
			
			
			Map<String,Object> msg = new HashMap<>();
			msg.put("productCode", "p1");
			msg.put("dateTime", 11111121);
			msg.put("msg", m2 );
			
//			ObjectMapper om = new ObjectMapper();
//			try {
//				byte[] value = om.writeValueAsBytes(msg);
//				client.prepareIndex("vd_iot_device_log", "device_log").setSource(value,XContentType.JSON);
////				IndexResponse index = client.prepareIndex("vd_iot_device_log", "device_log").setSource(value,XContentType.JSON).get();
////				System.out.println(index);
//
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//			IndexResponse index = client.prepareIndex("vd_iot_device_log5", "device_log5").setSource(msg).get();
//			System.out.println(index);
			
			
//			GetResponse response = client.prepareGet("vd_iot_device_log", "device_log", "1").get();
//			System.out.println(response.toString());
			
//			AbstractQueryBuilder<?> build = QueryBuilders.matchQuery("msg", "hello world");
//			AbstractQueryBuilder<?> build2 = QueryBuilders.rangeQuery("dateTime").from(111111212).to(111111212);
//			System.out.print(build2.toString());
			
			
			SearchResponse search = client.prepareSearch("vd_iot_device_log")
			        .setTypes("device_log")
//			        .setQuery(QueryBuilders.termQuery("productCode", "p2"))                 // Query
//			        .setPostFilter(QueryBuilders.boolQuery().should(build).should(build2)) 
			        .setPostFilter(QueryBuilders.wildcardQuery("deviceName", "lg_test7*"))
			        .setFrom(0).setSize(25)
			        .addSort("dateTime", SortOrder.DESC)
			        .get();
			
			search.getHits().forEach(item->{
				System.out.println(item.getSourceAsString());
			});
			
//			SearchResponse all = client.prepareSearch().get();
//			System.out.println(all);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			client.close();
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		ESTest es = new ESTest();
		es.testGet();
		
	}
	
	

}
