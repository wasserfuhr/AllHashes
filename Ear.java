import java.io.*;

public class Ear {
 public static void main(String[] args) throws Exception {
  FileInputStream fi = new FileInputStream("/Users/rawa/Desktop/raw.wav");
  System.out.println(fi.read());
 }
}