import java.io.File;

public class Dir {
 public static void dir(String d) throws Exception {
  for (File f:new File(d).listFiles()) {
   if (f.isDirectory()) {
   } else {
    System.out.println(f.getName());
   }
  }
 }
 public static void main(String[] args) throws Exception {
  dir(args[0]);
 }
}