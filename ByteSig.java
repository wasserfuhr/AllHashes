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
  dir =new File("/Users/rawa/Public/AllHashes");

  File[] files = dir.listFiles();
  for (File f : files) {
      if(f.getName().length()>4){
   FileInputStream fr=new FileInputStream(f);
   boolean[] sig=new boolean[256];
   int b;
   while((b=fr.read())>=0) {
    sig[b]=true;
   }
   //   System.out.print(f.getName().substring(0,64)+" ");
   System.out.print(f.getName()+" ");
   for(int i=255; i>=0; i-=4) {
    System.out.print(
     "0123456789abcdef".charAt(
			       (sig[i]?8:0)+
			       (sig[i-1]?4:0)));
   }
      }   System.out.println();
  }
 }
}