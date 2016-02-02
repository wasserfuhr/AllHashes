public class Cube {
 public static void main(String[] a) {
  byte b=new Byte(a[0]);
  int b2=1<<b;
  System.out.println(b2);
  byte c[][][]=new byte[b2][b2][b2];
  for (byte i=0;i<b2;i++) {
   c[i][i][i]=i;
  }
 }
}