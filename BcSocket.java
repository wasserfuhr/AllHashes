import org.java_websocket.client;
public class BcSocket extends WebSocketClient{
 public static void main(String[] a){
  new BcSocket(new java.net.URI("wss://ws.blockchain.info/inv"));}}