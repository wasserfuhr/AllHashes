import java.io.*;

public class Voice {
 public static void main(String[] a) throws Exception {
  //http://stackoverflow.com/questions/8754111/how-to-read-the-data-in-a-wav-file-to-an-array
  RandomAccessFile r = new RandomAccessFile(new File(a[0]),"rw");
  for (int i=0;i<20000;i++) {
   for (int j=0;j<512;j++) {
    r.seek(64+i*1024+j*2+1);
    r.write((byte)Math.round(Math.sin((2+((i>>4)%4))*j*3.14/512)*64));
   }
  }
 }
}