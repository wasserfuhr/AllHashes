import java.io.*;

public class Mv1220 {
 public static void main(String[] args) throws Exception {
  File dir=new File(args[0]);
  for (File f:dir.listFiles()) {
   f.renameTo(new File("1220"+f.getName()));
  }
 }
}