import java.io.*;

public class FileSize {

 public static String SD() throws Exception {
  if (System.getProperty("user.home").equals("/Users/rawa")) {
   return "/Volumes/SPACEDRIVE1/SpaceDrive/";
  }
  return "/home/rawa/SpaceDrive/";
 }

 public static String ext(String hash) throws Exception {
  String s059a="059af36cfe1132802ed9475f0a42d93033867ed843512e76a211491a17b1803f";
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(new FileInputStream(SD()+s059a+".txt")));
  return "txt";
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