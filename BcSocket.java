import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
public class BcSocket{
 public static void main(String[] a) throws Exception{
  org.java_websocket.WebSocketImpl.DEBUG = true;
  WebSocketClient c=new WebSocketClient(new java.net.URI("ws://ws.blockchain.info/inv")){
   @Override public void onMessage(String message ){System.out.println(message);}
   @Override public void onOpen(ServerHandshake handshake){System.out.println("open!");}
   @Override public void onClose(int code,String reason,boolean remote){}
   @Override public void onError(Exception e){e.printStackTrace();}};
  c.connect();
  c.send("{\"op\":\"blocks_sub\"}");
  BcSocket s=new BcSocket();
  synchronized(s){
   s.wait();}}}