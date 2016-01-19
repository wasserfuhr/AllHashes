import java.io.*;
import java.util.Date;

public class MdFive {
 public static void main(String[] args) throws Exception {
  //String s="5de061258156d9332fd2a5164af326d75d2c7a9392daf859f748a4248efb9379.zip";//50MB
  String s="32dcb58da8169e67ea3f97c4f89fcf7296ee5e744989f747d28c1a72df0721cc.mp4";//500MB
  //String s="5ed9c48362a92c19b6fe83ed1f09b2535672a64c468abcaa370d97b938aab61c.bz2";//3700MB
  long len=new File("G:/SpaceDrive/"+s).length();
  Date before=new Date();
  System.out.println(before+": Starting to hash "+len+" bytes");

 //https://www.fourmilab.ch/md5/
 //G:/SpaceDrive/770c0cdbb87b5ac036b79f5a4c48a2535fad71002bc2ffe88120713d4180c3e8.exe
  //Process p = Runtime.getRuntime().exec("c:\\Users\\RainerWasserfuhr\\Desktop\\md5.exe -l "+
  Process p = Runtime.getRuntime().exec("c:\\Users\\RainerWasserfuhr\\Desktop\\sha1sum.exe "+
//   "\\Users\\RainerWasserfuhr\\Desktop\\md5.exe");
   "G:/SpaceDrive/"+s);
  BufferedReader in = new BufferedReader(
   new InputStreamReader(p.getInputStream()));
  String l=in.readLine();
  System.out.println(l);
  System.out.println(new Date()+": done: "+len/(new Date().getTime()-before.getTime())+" KByte/s");
 }
}