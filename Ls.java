import java.io.*;
import java.util.*;

public class Ls {
 public static void main(String[] args) throws Exception {
  LineNumberReader lr=new LineNumberReader(new FileReader(
   new File(args[0]+
    "059af36cfe1132802ed9475f0a42d93033867ed843512e76a211491a17b1803f.txt")));
  String l;
  long ct=0;
  Hashtable h=new Hashtable();
  while(null!=(l=lr.readLine())) {
   h.put(l,"");
   ct++;
  }
  File d=new File(args[0]);
  String fs[]=d.list();
  for(String s:fs) {
   System.out.println(s.substring(0,64));
  }
 }
}