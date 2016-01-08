import java.io.File;
import java.io.FileInputStream;

public class ByteSig {
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
   FileInputStream fr=new FileInputStream(f);
   boolean[] sig=new boolean[256];
   int b;
   while((b=fr.read())>=0) {
    sig[b]=true;
   }
   System.out.print(f.getName().substring(0,64)+" ");
   for(int i=0; i<256; i++) {
    System.out.print(sig[i]?1:0);
   }
   System.out.println();
  }
 }
}