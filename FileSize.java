import java.io.*;

public class FileSize {
 public static void main(String[] a) throws Exception {
  LineNumberReader l=new LineNumberReader(new InputStreamReader(System.in));
  String s;
  while((s=l.readLine())!=null) {
   File f=new File(a[0]+"1220"+s+"."+SD.ext(s));
   System.out.println(s+" "+f.length());
  }
 }
}