import java.io.*;

public class EiNode {

 public static String execIn(ProcessBuilder pb) throws Exception {
  Process p = pb.start();
  BufferedReader in = new BufferedReader(
    new InputStreamReader(p.getInputStream()));
  String l=in.readLine();
  in.close();
  return l;
 }

 public static String execIn(String c0,String c1,String c2) throws Exception {
  return execIn(new ProcessBuilder(c0,c1,c2));
 }

 public static String execIn(String c0,String c1,String c2,String c3) throws Exception {
  return execIn(new ProcessBuilder(c0,c1,c2,c3));
 }

 public static void main(String[] args) throws Exception {
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  String f;
  while((f=lnr.readLine())!=null) {
   String li=execIn("ls","-i",f);
   String ls=execIn("shasum","-a","256",f);
   System.out.println(ls.split(" ")[0]+" "+li.split(" ")[0]);
  }
 }
}