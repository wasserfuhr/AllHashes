public class Cub {
 public static void main(String[] a) {
  byte b=new Byte(a[0]);
  short b2=(short)(1<<b);
  byte c[][][]=new byte[b2][b2][b2];
  for (short i=0;i<b2;i++) {
   c[i][i][i]=(byte)i;
  }
  for (short i=0;i<b2;i++) {
   for (short j=0;j<b2;j++) {
    for (short k=0;k<b2;k++) {
     System.out.print(c[i][j][k]);
    }
   }
  }
 }
}