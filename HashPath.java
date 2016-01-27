import java.io.*;

public class HashPath {
 public static String execIn(ProcessBuilder pb) throws Exception {
  Process p = pb.start();
  BufferedReader in = new BufferedReader(
    new InputStreamReader(p.getInputStream()));
  String l=in.readLine();
  in.close();
  return l;
 }

 public static String execIn(String c0,String c1) throws Exception {
  return execIn(new ProcessBuilder(c0,c1));
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
  String ls="";
  while((f=lnr.readLine())!=null) {
   if (OS.isWindows()) {
    String e="4867ccab1c36f33dec005e83eef8dfb6d3b166941a72400aa3c963675c2a7dae.exe";
<<<<<<< HEAD
    ls=execIn("G:/SpaceDrive/"+e,f);
   } else if (OS.isMac()) {
=======
    ls=execIn("G:/SpaceDrive/1220"+e,f).substring(1); // skip trailing "\"
   } else if (isMac()) {
>>>>>>> 8e956949c77dd27ed64301e4d8c889d45cd1ed68
    ls=execIn("shasum","-a","256",f);
   } else if (OS.isUnix()) {
    ls=execIn("sha256sum",f);
   } else {
    //???
   }
   System.out.println(ls.split(" ")[0]+" "+f);
  }
 }
}