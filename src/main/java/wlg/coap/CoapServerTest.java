package wlg.coap;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.EndpointManager;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.elements.tcp.TcpServerConnector;

public class CoapServerTest extends CoapServer {
	private static final int COAP_PORT = NetworkConfig.getStandard().getInt(NetworkConfig.Keys.COAP_PORT);
	private static final int TCP_THREADS = NetworkConfig.getStandard().getInt(NetworkConfig.Keys.TCP_WORKER_THREADS);
	private static final int TCP_IDLE_TIMEOUT = NetworkConfig.getStandard()
			.getInt(NetworkConfig.Keys.TCP_CONNECTION_IDLE_TIMEOUT);

	public static void main(String[] args) {
		// create server
		boolean udp = true;
		boolean tcp = false;
		if (0 < args.length) {
			tcp = args[0].equalsIgnoreCase("coap+tcp:");
			if (tcp) {
				System.out.println("Please Note: the TCP support is currently experimental!");
			}
		}
		
		System.out.println("COAP_PORT: " + COAP_PORT);
		System.out.println("TCP_THREADS: " + TCP_THREADS);
		System.out.println("TCP_IDLE_TIMEOUT: " + TCP_IDLE_TIMEOUT);
		
		CoapServerTest server = new CoapServerTest();
		// add endpoints on all IP addresses
		server.addEndpoints(udp, tcp);
		server.start();


	}

	/**
	 * Add individual endpoints listening on default CoAP port on all IPv4 addresses
	 * of all network interfaces.
	 */
	private void addEndpoints(boolean udp, boolean tcp) {
		NetworkConfig config = NetworkConfig.getStandard();
		for (InetAddress addr : EndpointManager.getEndpointManager().getNetworkInterfaces()) {
			InetSocketAddress bindToAddress = new InetSocketAddress(addr, COAP_PORT);
			if (udp) {
				CoapEndpoint.CoapEndpointBuilder builder = new CoapEndpoint.CoapEndpointBuilder();
				builder.setInetSocketAddress(bindToAddress);
				builder.setNetworkConfig(config);
				addEndpoint(builder.build());
			}
			if (tcp) {
				TcpServerConnector connector = new TcpServerConnector(bindToAddress, TCP_THREADS, TCP_IDLE_TIMEOUT);
				CoapEndpoint.CoapEndpointBuilder builder = new CoapEndpoint.CoapEndpointBuilder();
				builder.setConnector(connector);
				builder.setNetworkConfig(config);
				addEndpoint(builder.build());
			}

		}
	}
	
	public CoapServerTest() {
		add(new MyCoapResource());
	}
	
	
	private class MyCoapResource extends CoapResource {

		public MyCoapResource() {

			// set resource identifier
			super("helloWorld");

			// set display name
			getAttributes().setTitle("Hello-World Resource");
		}

		@Override
		public void handleGET(CoapExchange exchange) {
			// respond to the request
			exchange.respond("GET Hello World! ");
		}
		
		@Override
		public void handlePOST(CoapExchange exchange) {
			exchange.respond("POST Hello World");
		}
	}

}
