import java.io.*;

public class DeDup {
 public static void main(String[] a) throws Exception {
  LineNumberReader l = new LineNumberReader(new InputStreamReader(System.in));
  String s,ls=null;
  while((s=l.readLine())!=null) {
   if(!s.equals(ls)) {
    System.out.println(s);
   }
   ls=s;
  }
 }
}