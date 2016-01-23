import java.io.*;

/* UseCase:
 java Ls $SD|sort|diff - $SD$HI|sort|java DiffCount
*/
public class DiffCount {
 public static void main(String[] args) throws Exception {
  LineNumberReader lr = new LineNumberReader(new InputStreamReader(System.in));
  long ct0=0;
  long ct1=0;
  String l;
  while(null!=(l=lr.readLine())) {
   if (l.startsWith("<")) ct0++;
   if (l.startsWith(">")) ct1++;
  }
  System.out.println(ct0+" "+ct1);
 }
}