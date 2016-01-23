import java.io.*;

public class LineLen {
 public static void main(String[] args) throws Exception {
  LineNumberReader lr = new LineNumberReader(new InputStreamReader(System.in));
  String l;
  while(null!=(l=lr.readLine())) {
   System.out.println(l.length());
  }
 }
}