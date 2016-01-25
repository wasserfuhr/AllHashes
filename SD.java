public class SD {
 public static String SD() throws Exception {
  if (System.getProperty("user.home").equals("/Users/rawa")) {
   return "/Volumes/SPACEDRIVE1/SpaceDrive/";
  }
  return "/home/rawa/SpaceDrive/";
 }
}