import java.io.File;
import java.util.*;

public class SpaceDrive {
 public static void dir(String d) throws Exception {
  Hashtable h=new Hashtable();
  for (File f:new File(d).listFiles()) {
   if (f.getName().length()<65){
    System.err.println(f.getName());
   }
   String ext=f.getName().substring(65);
   if (h.containsKey(ext)) {
       h.put(ext,(Integer)h.get(ext)+1);
   } else {
    h.put(ext,1);
   }
  }
  for (Object k:h.keySet()) {
   System.out.println(k+" "+h.get(k));
  }
 }
 public static void main(String[] args) throws Exception {
  dir(args[0]);
 }
}