import java.io.*;
public class SubStr{
 public static void main(String[]a)throws Exception{
  LineNumberReader l=new LineNumberReader(new InputStreamReader(System.in));
  int begin=new Integer(a[0]);
  String s;while(null!=(s=l.readLine())){
   if(a.length>1){
    int end=new Integer(a[1]);
    System.out.print(s.substring(begin,end)+"\n");}
   else{
    System.out.print(s.substring(begin)+"\n");}}}}