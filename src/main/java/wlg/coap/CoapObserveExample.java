package wlg.coap;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.*;

import java.net.InetSocketAddress;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapObserveExample extends CoapResource {
	private static final int COAP_PORT = NetworkConfig.getStandard().getInt(NetworkConfig.Keys.COAP_PORT);
	
	public CoapObserveExample(String name) {
		super(name);
		setObservable(true); // enable observing
		setObserveType(Type.CON); // configure the notification type to CONs
		getAttributes().setObservable(); // mark observable in the Link-Format
		
		// schedule a periodic update task, otherwise let events call changed()
		Timer timer = new Timer();
		timer.schedule(new UpdateTask(), 0, 1000);
	}
	
	private class UpdateTask extends TimerTask {
		@Override
		public void run() {
			// .. periodic update of the resource
			changed(); // notify all observers
		}
	}
	
	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.setMaxAge(1); // the Max-Age value should match the update interval
		exchange.respond("update");
	}
	
	@Override
	public void handleDELETE(CoapExchange exchange) {
		delete(); // will also call clearAndNotifyObserveRelations(ResponseCode.NOT_FOUND)
		exchange.respond(DELETED);
	}
	
	@Override
	public void handlePUT(CoapExchange exchange) {
		// ...
		exchange.respond(CHANGED);
		changed(); // notify all observers
	}
	
	public static void main(String[] args) {
		CoapServer server = new CoapServer();
		
		InetSocketAddress bindToAddress = new InetSocketAddress("127.0.0.1", COAP_PORT);
		NetworkConfig config = NetworkConfig.getStandard();
		CoapEndpoint.CoapEndpointBuilder builder = new CoapEndpoint.CoapEndpointBuilder();
		builder.setInetSocketAddress(bindToAddress);
		builder.setNetworkConfig(config);
		server.addEndpoint(builder.build());
		
		server.add(new CoapObserveExample("helloWorld"));
		server.start();
	}
}
