//http://stackoverflow.com/questions/4741878/redirect-runtime-getruntime-exec-output-with-system-setout
import java.io.*;
 
public class EiNode {
 public static void main(String[] args) throws Exception  {
  String f="/Volumes/SPACEDRIVE1/CastDups.txt";
  Process p = Runtime.getRuntime().exec("ls -i "+f);
  BufferedReader in = new BufferedReader(
   new InputStreamReader(p.getInputStream()));
  String l=in.readLine();
  Process p1 = Runtime.getRuntime().exec("shasum -a 256 "+f);
  String l2 = new BufferedReader(
   new InputStreamReader(p1.getInputStream())).readLine();
  System.out.println(">"+l2.split(" ")[0]+"< "+l.split(" ")[0]);
  in.close();
 }
}