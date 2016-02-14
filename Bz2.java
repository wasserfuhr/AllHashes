import java.io.*;
import java.nio.charset.Charset;
import org.apache.tools.bzip2.CBZip2InputStream;

public class Bz2 {
 public static void main(String[] a) throws Exception {
  //http://www.programcreek.com/java-api-examples/index.php?api=org.apache.tools.bzip2.CBZip2InputStream
  InputStream is = new BufferedInputStream(new FileInputStream(a[0]), 8192);
  is.read(); is.read();
  is = new CBZip2InputStream(is);
  LineNumberReader l = new LineNumberReader(new InputStreamReader(is, Charset.forName("UTF-8")));
  String s;
  while((s=l.readLine())!=null) {
   System.out.println(s);
  }
 }
}