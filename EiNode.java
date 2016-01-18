import java.io.*;

public class EiNode {
 public static String execIn(String c) throws Exception {
  //http://stackoverflow.com/questions/4741878/redirect-runtime-getruntime-exec-output-with-system-setout
  Process p = Runtime.getRuntime().exec(c);
  BufferedReader in = new BufferedReader(
    new InputStreamReader(p.getInputStream()));
  String l=in.readLine();
  in.close();
  return l;
 }

 public static void main(String[] args) throws Exception {
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  String f;
  while((f=lnr.readLine())!=null){
   String li=execIn("ls -i "+f);
   String ls=execIn("shasum -a 256 "+f);
   System.out.println(ls.split(" ")[0]+" "+li.split(" ")[0]);
  }
 }
}