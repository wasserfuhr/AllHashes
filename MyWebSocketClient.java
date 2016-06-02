//http://stackoverflow.com/questions/8352980/application-to-application-communication-through-web-sockets
import org.eclipse.jetty.websocket.*;
public class MyWebSocketClient{
  MyWebSocketClient() throws IOException
    {       
        WebSocketClientFactory factory = new WebSocketClientFactory();
        try {
          factory.start();
        } catch(Exception e){e.printStackTrace();}
        WebSocketClient client = factory.newWebSocketClient();
        WebSocket.Connection connection = client.open(new URI("ws://myserver:8080/testws"),new WebSocket.OnTextMessage(){
		public void onOpen(Connection connection){}
		public void onClose(int closeCode, String message){}

	   public void onMessage(String data){}
	    }).get(50, TimeUnit.SECONDS);

	    }