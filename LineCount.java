import java.io.*;

public class LineCount {
 public static void main(String[] args) throws Exception {
  LineNumberReader lr = new LineNumberReader(new InputStreamReader(System.in));
  long ct=0;
  String l;
  while(null!=(l=lr.readLine())) {
   ct++;
  }
  System.out.println(ct);
 }
}