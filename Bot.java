import java.io.*;

public class Bot {
 public static void main(String[] args) throws Exception {
  File dir=new File(args[0]);
  for (File f:dir.listFiles()) {
   FileInputStream fr=new FileInputStream(f);
   String s=f.getName().substring(0,64);
   System.out.println(s+" "+f.length());
  }
 }
}