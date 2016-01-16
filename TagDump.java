import java.io.*;

/*import com.drew.imaging.*;
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
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.iptc.*;
import com.drew.metadata.exif.*;
import com.drew.metadata.jpeg.*;
import com.drew.metadata.iptc.IptcReader;
*/

public class TagDump {
 public static String SD() throws Exception {
  if (System.getProperty("user.home").equals("/Users/rawa")) {
   return "/Volumes/SPACEDRIVE1/SpaceDrive/";
  }
  return "/home/rawa/SpaceDrive/";
 }

 public static void main(String[] args) throws Exception {
  File jf = new File(SD()+"ffe73037035bd0ba401dab87e3d1bb422c3590107aa70e9a14cb2ac77d110ae9.jpg");
  System.out.println(jf.length());
  /*  Metadata metadata = ImageMetadataReader.readMetadata(jf);
  for (Directory directory : metadata.getDirectories()) {
   for (Tag tag : directory.getTags()) {
    System.out.println(tag);
   }
   }*/
 }
}