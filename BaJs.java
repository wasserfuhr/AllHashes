import java.io.*;

public class BaJs {
 public static void main(String[] args) throws Exception {
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  String s;
  while((s=lnr.readLine())!=null){
   String s0=s.substring(0,64);
   String s1=s.substring(65,65+40);
   String s2=s.substring(65+40);
   System.out.println("mv "+s1+s2+" d/"+s0+s2);
  } 
 }
}
