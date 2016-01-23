import java.io.*;

import com.drew.imaging.*;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.*;
import com.drew.metadata.Directory;
import com.drew.metadata.*;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
//import com.drew.metadata.exif.ExifReader;
//import com.drew.metadata.iptc.*;
//import com.drew.metadata.exif.*;
//import com.drew.metadata.jpeg.*;
//import com.drew.metadata.iptc.IptcReader;

/*
 javac -cp md.jar:xmp.jar TagDump.java 
 java -cp md.jar:xmp.jar:. TagDump
*/
public class TagDump {
 public static void main(String[] args) throws Exception {
     //  File jf = new File(args[0]+"ffe73037035bd0ba401dab87e3d1bb422c3590107aa70e9a14cb2ac77d110ae9.jpg");
  File jf = new File("tmp.jpg");
  //File jf = new File(args[0]+"12b0bf8c17aa0bc46bf73eedfe970029f90a94dec5ff4152542a31945231e255.png");
  Metadata metadata = ImageMetadataReader.readMetadata(jf);
  for (Directory d:metadata.getDirectories()) {
   for (Tag t:d.getTags()) {
    System.out.println(d.getName()+"-"+t.getTagTypeHex()+" "+t);
   }
  }
 }
}