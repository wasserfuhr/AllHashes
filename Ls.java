import java.io.*;

public class Ls {
 public static void main(String[] a) throws Exception {
  for(String s:new File(a[0]).list()) {
   System.out.println(s.substring(4,68));
  }
 }
}