import java.io.*;

public class FileSize {
 public static String ext(String hash) {
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  return "txt";
 }

 public static String SD() throws Exception {
  if (System.getProperty("user.home").equals("/Users/rawa")) {
   return "/Volumes/SPACEDRIVE1/SpaceDrive/";
  }
  return "/home/rawa/SpaceDrive/";
 }

 public static void main(String[] args) throws Exception {
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  String s;
  while((s=lnr.readLine())!=null){
      File f=new File(SD()+s+"."+ext(s));
   if(f.exists()){
    System.out.println(s+" "+f.length());
   }
  }
 }
}