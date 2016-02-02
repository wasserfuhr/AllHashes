public class Cube {
 public static void main(String[] a) {
  int c[][][]=new int[1024][1024][4096];
  for (int i=0;i<256;i++) {
   c[i][i][i]=i;
  }
 }
}