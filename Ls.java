import java.io.*;

public class Ls {
//059af36cfe1132802ed9475f0a42d93033867ed843512e76a211491a17b1803f.txt
 public static void main(String[] args) throws Exception {

LineNumberReader lr=new LineNumberReader(new FileReader(new File("H:/SpaceDrive/059af36cfe1132802ed9475f0a42d93033867ed843512e76a211491a17b1803f.txt")));
String l;int ct=0;
while(null!=(l=lr.readLine())) {
   System.out.println(ct+" "+l);
ct++;
}

  File d=new File("H:/SpaceDrive");
  String fs[]=d.list();
  for(String s:fs) {
   System.out.println(s);
  }
 }
}