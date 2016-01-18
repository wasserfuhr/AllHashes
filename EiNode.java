//http://stackoverflow.com/questions/4741878/redirect-runtime-getruntime-exec-output-with-system-setout
import java.io.*;
 
public class EiNode {
 public static void main(String[] args) throws Exception  {
  Process p = Runtime.getRuntime().exec( "ls -i /Volumes/SPACEDRIVE1/CastDups.txt");
  BufferedReader in = new BufferedReader(
    new InputStreamReader(p.getInputStream()) );
  String l;
  while ((l = in.readLine()) != null) {
   System.out.println(l);
  }
  in.close();
 }
}