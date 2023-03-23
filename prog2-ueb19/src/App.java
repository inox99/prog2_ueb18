@SuppressWarnings("unused")

public class App {
   static class Elem {
      String s = "";

      public Elem(String s) {
         this.s = s;
      }

      public String toString() {
         return s;
      }
   }

   public static void main(String[] args) throws Exception {
      GList<Elem> list = new GList<Elem>();
      Elem e1, e2, e3;
      list.add(e1 = new Elem("1"));
      list.add(e2 = new Elem("2"));
      list.add(e3 = new Elem("3"));

      // for (Elem e : list.toArray(new Elem[0])) {
      // System.out.println(e.toString());
      // }

      // // ------------------------------
      // // test contains
      // Elem e4, e5;
      // list.add(e4 = new Elem("4"));
      // e5 = new Elem("5");
      // for (Elem e : list.toArray(new Elem[0])) {
      // System.out.println(e.toString());
      // }
      // System.out.println(list.contains(e1));
      // System.out.println(list.contains(e4));
      // System.out.println(list.contains(e5));

      // ------------------------------
      // test remove
      for (Elem e : list.toArray(new Elem[0])) {
         System.out.println(e.toString());
      }
      System.out.println(list.remove(e1));
      Elem e5 = new Elem("5");
      System.out.println(list.remove(e5));
      for (Elem e : list.toArray(new Elem[0])) {
         System.out.println(e.toString());
      }
   }
}