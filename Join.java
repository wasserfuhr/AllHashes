import java.io.*;
import java.util.*;
//e.g.:
// cat BootStrap.txt|java Join AeDump/DumpHash.txt|more
public class Join {
 public static void main(String[] a) throws Exception {
  Hashtable h=new Hashtable();
  FileInputStream fis=new FileInputStream(a[0]);
  LineNumberReader lr = new LineNumberReader(new InputStreamReader(fis));
  String l;
  while(null!=(l=lr.readLine())) {
   h.put(l.split(" ")[0],l.split(" ")[1]);
  }
  lr = new LineNumberReader(new InputStreamReader(System.in));
  while(null!=(l=lr.readLine())) {
   System.out.print(l);
   if(h.containsKey(l)) {
    System.out.print(" "+h.get(l));
   }
   System.out.println();
  }
 }
}