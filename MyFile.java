//http://www.javacodex.com/More-Examples/1/8
import java.nio.file.*;
import java.nio.file.attribute.*;
 
public class MyFile {
 
    public static void main(String[] args) throws Exception  {
 
	BasicFileAttributes attr = null;
	Path path = Paths.get("MyFile.java");
 
	attr = Files.readAttributes(path, BasicFileAttributes.class);
 
	Object fileKey = attr.fileKey();
	String s = fileKey.toString();
	String inode = s.substring(s.indexOf("ino=") + 4, s.indexOf(")"));
	System.out.println("Inode: " + inode);
    }
}