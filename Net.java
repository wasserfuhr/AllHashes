import java.net.*;
//https://systembash.com/a-simple-java-udp-server-and-udp-client/
public class Net{
 public static void main(String[] a)throws Exception{
  DatagramSocket s = new DatagramSocket(9876);
  byte[] receiveData = new byte[1024];
  byte[] sendData = new byte[1024];
  while(true){
	     DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	     serverSocket.receive(receivePacket);
	     String sentence = new String( receivePacket.getData());
	     System.out.println("RECEIVED: " + sentence);
	     InetAddress IPAddress = receivePacket.getAddress();
	     int port = receivePacket.getPort();
	     String capitalizedSentence = sentence.toUpperCase();
	     sendData = capitalizedSentence.getBytes();
                  DatagramPacket sendPacket =
		      new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  s.send(sendPacket);
	 }
	 }	 }
