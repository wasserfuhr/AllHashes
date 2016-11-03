import java.net.*;
//https://systembash.com/a-simple-java-udp-server-and-udp-client/
public class Net{
 public static void main(String[]a)throws Exception{
  DatagramSocket s=new DatagramSocket(1337);
  byte[] rd=new byte[1024];
  byte[] sd=new byte[1024];
  while(true){
   DatagramPacket rp=new DatagramPacket(rd,rd.length);
   s.receive(rp);
   String sen=new String(rp.getData());
   System.out.println("IN: "+sen);
   System.out.println(" "+rp.getLength());
   sd=sen.toUpperCase().getBytes();
   DatagramPacket sp=new DatagramPacket(sd,sd.length,rp.getAddress(),rp.getPort());
   s.send(sp);}}}