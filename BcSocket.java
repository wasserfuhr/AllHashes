import org.java_websocket.client.WebSocketClient;
public class BcSocket extends WebSocketClient{
 public static void main(String[] a){
  new BcSocket(new java.net.URI("wss://ws.blockchain.info/inv"));}}