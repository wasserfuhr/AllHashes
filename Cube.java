public class Cube {
 public static void main(String[] a) {
  byte b=new Byte(a[0]);
  byte b2=(byte)(1<<b);
  byte c[][][]=new byte[b2][b2][b2];
  for (byte i=0;i<b2;i++) {
   c[i][i][i]=i;
  }
 }
}