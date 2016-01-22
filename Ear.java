import java.io.*;

public class Ear {
 public static void main(String[] a) throws Exception {
  //http://stackoverflow.com/questions/8754111/how-to-read-the-data-in-a-wav-file-to-an-array
     //  FileInputStream fi = new FileInputStream("/Users/rawa/Desktop/raw.wav");
     //  FileInputStream fi = new FileInputStream("/Users/rawa/Desktop/Schoen.wav");
  FileInputStream fi = new FileInputStream(a[0]);
  int b;
  while((b=fi.read())>=0) {
   if(b>127)b=255-b;
   b=b/4;
   for (int i=0;i<64+b;i++) {
    System.out.print(".");
   }
   fi.read();
   fi.read();
   fi.read();
   System.out.println();
  }
 }
}