import java.io.*;
public class RiscJay{
 public static void main(String[]a) throws Exception{
  InputStreamReader i=new InputStreamReader(System.in);
  int b;
  long pc=0;
  while((b=i.read())>=0){
   long w=b<<8+i.read();
   w+=w<<8+i.read();
   w+=w<<8+i.read();
   w+=w<<8+i.read();}}}