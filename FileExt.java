import java.io.*;

public class FileExt {
 public static void main(String[] a) throws Exception {
  File dir=new File(a[0]);
  File[] files = dir.listFiles();
  for (File f:files) {
   System.out.println(f.getName().substring(4));
  }
 }
}