public class Ur extends Thread{
 public void run(){//throws Exception{
  try{
   long lastSec=0;
   while(true){
    long c=System.currentTimeMillis();
    long t=(lastSec+1)*1000-c;
    if(t>0){
     sleep(t/2-10);
    }else{
     System.out.println(c);
     Runtime.getRuntime().exec("/home/rawa/git/AllHashes/job.sh");
     lastSec=c/1000;}}
  }catch(Exception e){}}
 public static void main(String[] a)throws Exception{
  new Ur().start();}}