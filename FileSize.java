import java.io.*;

public class FileSize {
 public static String ext(String hash) {
  return "txt";
 }

 public static void main(String[] args) throws Exception {
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  String s;
  while((s=lnr.readLine())!=null){
      File f=new File("/home/rawa/SpaceDrive/"+s+"."+ext(s));
   if(f.exists()){
    System.out.println(s+" "+f.length());
   }
  }
 }
}