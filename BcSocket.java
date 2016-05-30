import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
public class BcSocket extends WebSocketClient{

    @Override
	public void onMessage( String message ) {
    }

    @Override
	public void onOpen( ServerHandshake handshake ) {
    }

    @Override
	public void onClose( int code, String reason, boolean remote ) {
    }

    @Override
	public void onError( Exception ex ) {
    }
 public static void main(String[] a){
  new BcSocket(new java.net.URI("wss://ws.blockchain.info/inv"));}}