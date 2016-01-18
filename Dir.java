import java.io.File;

public class Dir {
 public static void dir(String d) throws Exception {
  for (File f:new File(d).listFiles()) {
   if (!f.isHidden()){
    String s=f.getParent()+"/"+f.getName();
     System.out.println(s);
    if (f.isDirectory()) {
     dir(s);
    } else {
     System.out.println(s);
    }
   }
  }
 }
 public static void main(String[] args) throws Exception {
  dir(args[0]);
 }
}