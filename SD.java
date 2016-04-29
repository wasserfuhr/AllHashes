import java.io.*;
import java.nio.file.*;
public class SD{
 public static String SD() throws Exception{
  if (System.getProperty("user.home").equals("/Users/rawa")){
   return "/Volumes/SPACEDRIVE1/SpaceDrive/";}
  return "/home/rawa/SpaceDrive/";}
 public static String ext(String hash) throws Exception{
  LineNumberReader lnr=new LineNumberReader(new InputStreamReader(new FileInputStream("FileExtLd4294.txt")));
  String s;while((s=lnr.readLine())!=null){
   if(s.substring(0,64).equals(hash)){
    return s.substring(65);}}
  DirectoryStream<Path>stream=Files.newDirectoryStream(
   FileSystems.getDefault().getPath(SD()),"1220"+hash+".*");
  for(final Path p:stream){
   File f=p.toFile();
   String s=f.getName().substring(69);
   f.close();
   return s;}
  return null;}
 public static void main(String[]a)throws Exception{
  ext("a0fcb8c6406166fcc446b455b4df9558ce441aa26536a469be4c26d784d74bd4x");}}