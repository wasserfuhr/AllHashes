import java.io.File;
import java.io.FileInputStream;

public class FileTime {
 public static String SD() throws Exception {
  if (System.getProperty("user.home").equals("/Users/rawa")) {
   return "/Volumes/SPACEDRIVE1/SpaceDrive/";
  }
  return "/home/rawa/SpaceDrive/";
 }

 public static void main(String[] args) throws Exception {
  File dir=new File(SD());
  dir =new File("/Users/rawa/Public/AllHashes");

  File[] files = dir.listFiles();
  for (File f : files) {
   System.out.print(f.getLastModified());
  }
 }
}