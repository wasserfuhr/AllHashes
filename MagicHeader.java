import java.io.*;

public class MagicHeader {
 public static void main(String[] args) throws Exception {
  File dir=new File("/Volumes/SPACEDRIVE1/SpaceDrive/");
  File[] files = dir.listFiles();
  for (File f : files) {
   System.out.print(f.getName().substring(0,64)+" ");
   FileInputStream fr=new FileInputStream(f);
   byte[] buf = new byte[8];
   int ct=fr.read(buf);
   for(int i=0; i<ct; i++) {
    System.out.print(String.format("%02x",buf[i]& 0xff));
   }
   System.out.println();
  }
 }
}