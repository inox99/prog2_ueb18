public class App {
   static int n = 0;

   public static boolean findRecursive(String haystack, String needle) {
      if (haystack.substring(n, n + needle.length()) == needle) {
         n = 0;
         return true;
      } else {
         n++;
         findRecursive(haystack, needle);
      }
      if (haystack.length() < needle.length()) {
         return false;
      }
      if (haystack.length() < n + needle.length()) {
         return false;
      }
      // Zeigt hier Felher an braucht noch einen return Wert
   }

   public static void main(String[] args) {
      System.out.println(findRecursive("Hallo", "all"));
   }
}
