import org.java_websocket.client.WebSocketClient;
public class BcSocket extends WebSocketClient{

    @Override
	public void onMessage( String message ) {
	ta.append( "got: " + message + "\n" );
	ta.setCaretPosition( ta.getDocument().getLength() );
    }

    @Override
	public void onOpen( ServerHandshake handshake ) {
	ta.append( "You are connected to ChatServer: " + getURI() + "\n" );
	ta.setCaretPosition( ta.getDocument().getLength() );
    }

    @Override
	public void onClose( int code, String reason, boolean remote ) {
	ta.append( "You have been disconnected from: " + getURI() + "; Code: " + code + " " + reason + "\n" );
	ta.setCaretPosition( ta.getDocument().getLength() );
	connect.setEnabled( true );
	uriField.setEditable( true );
	draft.setEditable( true );
	close.setEnabled( false );
    }

    @Override
	public void onError( Exception ex ) {
	ta.append( "Exception occured ...\n" + ex + "\n" );
	ta.setCaretPosition( ta.getDocument().getLength() );
	ex.printStackTrace();
	connect.setEnabled( true );
	uriField.setEditable( true );
	draft.setEditable( true );
	close.setEnabled( false );
    }
 public static void main(String[] a){
  new BcSocket(new java.net.URI("wss://ws.blockchain.info/inv"));}}