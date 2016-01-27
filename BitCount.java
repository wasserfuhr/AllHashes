import java.io.*;

public class BitCount {
 public static void main(String[] a) throws Exception {
  LineNumberReader l = new LineNumberReader(new InputStreamReader(System.in));
  String s;
  while((s=lnr.readLine())!=null) {
   FileInputStream fr=new FileInputStream(SD.ext(s));
   int bitCt=0;
   int b;
   while((b=fr.read())>=0) {
    for(int i=0; i<8; i++) {
     if(0<(b&(1<<i))) {
      bitCt++;
     }
    }
   }
   System.out.println(s+" "+bitCt);
  }
 }
}