import java.io.*;
public class Ls{
 public static void main(String[]a)throws Exception{
  for(String s:new File(a[0]).list()){
   System.out.print(s.substring(4,68)+"\n");}}}