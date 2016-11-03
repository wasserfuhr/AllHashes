import java.net.*;
//https://systembash.com/a-simple-java-udp-server-and-udp-client/
public class Net{
 public static void main(String[] a)throws Exception{
  DatagramSocket s=new DatagramSocket(9876);
  byte[] rd=new byte[1024];
  byte[] sd=new byte[1024];
  while(true){
   DatagramPacket rp=new DatagramPacket(receiveData, receiveData.length);
   s.receive(receivePacket);
   String sen=new String(rp.getData());
   System.out.println("IN: " + sen);
   System.out.println(" " + sen.getLength());
   InetAddress IPAddress=rp.getAddress();
   sd=sen.toUpperCase().getBytes();
   DatagramPacket sp=new DatagramPacket(sd, sd.length, IPAddress,rp.getPort());
   s.send(sp);}}}