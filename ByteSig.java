import java.io.File;
import java.io.FileInputStream;

public class BitCount {
 public static void main(String[] args) throws Exception {
  File dir=new File("/Volumes/SPACEDRIVE1/SpaceDrive/");
  File[] files = dir.listFiles();
  for (File f : files) {
   FileInputStream fr=new FileInputStream(f);
   int bitCt=0;
   int b;
   while((b=fr.read())>=0) {
    for(int i=0; i<8; i++) {
     if(0<(b&(1<<i))) {
      bitCt++;
     }
    }
   }
   System.out.println(f.getName().substring(0,64)+" "+bitCt);
  }
 }
}