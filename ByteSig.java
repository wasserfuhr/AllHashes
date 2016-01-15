import java.io.*;

public class ByteSig {
 public static String SD() throws Exception {
  if (System.getProperty("user.home").equals("/Users/rawa")) {
   return "/Volumes/SPACEDRIVE1/SpaceDrive/";
  }
  return "/home/rawa/SpaceDrive/";
 }

 public static void main(String[] args) throws Exception {
  LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
  String s;
  while((s=lnr.readLine())!=null){
   String s0=s.substring(0,64);
   System.out.print(s0+" ");
   File f =new File(s0+".mp4");
   FileInputStream fr=new FileInputStream(SD()+f);
   boolean[] sig=new boolean[256];
   int b;
   while((b=fr.read())>=0) {
    sig[b]=true;
   }
   for(int i=255; i>=0; i-=4) {
    System.out.print(
     "0123456789abcdef".charAt(
      (sig[i]?8:0)+
      (sig[i-1]?4:0)+
      (sig[i-2]?2:0)+
      (sig[i-3]?1:0)));
   }
   System.out.println();
  }
 }
}