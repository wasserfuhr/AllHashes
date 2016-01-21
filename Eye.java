import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Eye {
 public static void main(String[] args) throws Exception {
  File f = new File(args[0]+"ffe73037035bd0ba401dab87e3d1bb422c3590107aa70e9a14cb2ac77d110ae9.jpg");
  //http://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image
  BufferedImage i=ImageIO.read(f);
  System.out.println(i.getWidth()+"x"+i.getHeight());
  for (int y=0;y<64;y++) {
   for (int x=0;x<64;x++) {
    int p=i.getRGB(440+x,1520+y);
    String s=String.format("%02x ",p);
    System.out.print(s.substring(2,3));
   }
   System.out.println();
  }
 }
}