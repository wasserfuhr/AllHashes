public class Ur{
 public static void main(String[] a){
  long lastSec=0;
  while(true){
   long c=System.currentTimeMillis();
   if(c/1000>lastSec){
    System.out.println(c);
    lastSec=c/1000;}}}}