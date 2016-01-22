import java.io.*;

public class Voice {
 public static void main(String[] a) throws Exception {
  //http://stackoverflow.com/questions/8754111/how-to-read-the-data-in-a-wav-file-to-an-array
 RandomAccessFile r = new RandomAccessFile(new File(a[0]),"rw");
 for (int i=0;i<28000;i++) {
   for (int j=0;j<256;j++) {
    r.seek(64+i*128+j*4);
    r.write(j);
    r.seek(64+i*128+j*4+1);
    r.write(j);
    r.seek(64+i*128+j*4+2);
    r.write(j);
   }
  }
 }
}