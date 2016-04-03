public class Ur{
 public static void main(String[] a){
  long lastSec=0;
  while(true){
   long c=System.currentTimeMillis();
   if(c/1000>lastSec){
    System.out.println(c);
    Runtime.getRuntime().exec("/home/rawa/git/AllHashes/job.sh");
    lastSec=c/1000;}}}}