public class Mem {
 public static void main(String[] a) {
  System.out.println(Runtime.getRuntime().totalMemory()+" total");
  System.out.println(Runtime.getRuntime().maxMemory()+" max");
  System.out.println(Runtime.getRuntime().freeMemory()+" free");
 }
}