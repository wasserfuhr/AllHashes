import java.io.*;
//grep for output of md5
public class GrepMd5 {
 public static void main(String[] args) throws Exception {
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  String s;
  while((s=lnr.readLine())!=null){
   String s0=s.substring(5,69);
   String s1=s.substring(s.indexOf(") = ")+4);
   System.out.println(s1+" "+s0);
  }
 }
}