import java.io.*;

public class SubStr {
 public static void main(String[] args) throws Exception {
  LineNumberReader lr = new LineNumberReader(new InputStreamReader(System.in));
  String l;
  int begin=new Integer(args[0]);
  int end=new Integer(args[1]);
  while(null!=(l=lr.readLine())) {
   System.out.println(l.substring(begin,end));
  }
 }
}