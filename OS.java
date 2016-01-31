public class OS {
 //http://stackoverflow.com/questions/228477/how-do-i-programmatically-determine-operating-system-in-java
 private static String OS = System.getProperty("os.name").toLowerCase();

 public static boolean isWindows() {
  return (OS.indexOf("win") >= 0);
 }

 public static boolean isMac() {
  return (OS.indexOf("mac") >= 0);
 }

 public static boolean isUnix() {
  return (OS.indexOf("nux") >= 0);
 }

 public static void main(String[] args) throws Exception {
  String ls="";
  if (isWindows()) {
   //..
  } else if (isMac()) {
   //..
  } else if (isUnix()) {
   //..
  } else {
   //???
  }
 }
}