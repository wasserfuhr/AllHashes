import java.io.*;
public class ByteCt{
 public static void main(String[]a) throws Exception {
  InputStreamReader r=new InputStreamReader(System.in));
  int b;
  int[] sig=new int[256];
  while((b=fr.read())>=0){
   sig[b]++;
  }
  for(int i=0;i<256;i++){
   System.out.println(b+" "+sig[i]);
  }
 }
}