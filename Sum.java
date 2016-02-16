import java.io.*;

public class Sum{
 public static void main(String[]a) throws Exception{
  LineNumberReader lnr=new LineNumberReader(new InputStreamReader(System.in));
  long sum=0;String s;
  while((s=lnr.readLine())!=null){
   sum+=new Long(s);}
  System.out.println(sum);}}