public class App {
   static int n = 0;

   public static boolean findRecursive_(String haystack, String needle) {
      if (haystack.length() < n + needle.length()) {
         return false;
      }

      // if (haystack.substring(n, n + needle.length()) == needle) {
      if (haystack.substring(n, n + needle.length()).equals(needle)) {
         n = 0;
         return true;
      } else {
         n++;
         findRecursive(haystack, needle);
      }
      // if (haystack.length() < needle.length()) {
      // return false;
      // }
      // Zeigt hier Felher an braucht noch einen return Wert
      return false;
   }

   public static boolean findRecursive__(String haystack, String needle) {
      if (haystack.length() < n + needle.length()) {
         return false;
      }
      if (!haystack.substring(n, n + needle.length()).equals(needle)) {
         n++;
         return findRecursive(haystack, needle);
      } else {
         n = 0;
         return true;
      }
   }

   public static boolean findRecursive(String haystack, String needle) {
      if (haystack.length() < n + needle.length()) {
         return false;
      }
      if (haystack.substring(n, n + needle.length()).equals(needle)) {
         n = 0;
         return true;
      } else {
         n++;
         return findRecursive(haystack, needle);
      }
   }

   public static void main(String[] args) {
      System.out.println(findRecursive("Hallo", "o"));
   }
}
