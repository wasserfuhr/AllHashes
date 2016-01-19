import java.io.*;

public class HashPath {

 //http://stackoverflow.com/questions/228477/how-do-i-programmatically-determine-operating-system-in-java
 private static String OS = System.getProperty("os.name").toLowerCase();

 public static void detectOS() {
  if (isWindows()) {
   String e="4867ccab1c36f33dec005e83eef8dfb6d3b166941a72400aa3c963675c2a7dae.exe";
   String ls=execIn("G:/"+e,f);
  } else if (isMac()) {
   String ls=execIn("shasum","-a","256",f);
  } else if (isUnix()) {
   String ls=execIn("sha256sum",f);
  } else {
   //???
  }
 }

 private static boolean isWindows() {
  return (OS.indexOf("win") >= 0);
 }

 private static boolean isMac() {
  return (OS.indexOf("mac") >= 0);
 }

 private static boolean isUnix() {
  return (OS.indexOf("nux") >= 0);
 }

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

 public static String ShaTfs(String[] args) throws Exception {
 }

 public static void main(String[] args) throws Exception {
  System.out.println();
  if(System.getProperty("os.name").startsWith("Windows")) {
  }
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  String f;
  while((f=lnr.readLine())!=null) {
   String li=execIn("ls","-i",f);
   String ls=execIn("shasum","-a","256",f);
   System.out.println(ls.split(" ")[0]+" "+li.split(" ")[0]);
  }
 }
}