import java.io.*;

public class FileExt {

 public static String SD() throws Exception {
  if (System.getProperty("user.home").equals("/Users/rawa")) {
   return "/Volumes/SPACEDRIVE1/SpaceDrive/";
  }
  return "/home/rawa/SpaceDrive/";
 }

 public static void main(String[] args) throws Exception {
  File dir=new File(SD());
  File[] files = dir.listFiles();
  for (File f : files) {
   System.out.println(f.getName());
  }
 }
}