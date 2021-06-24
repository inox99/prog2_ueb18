import java.util.function.Predicate;

interface ICall {
   int call(int i);
}

class Call1 implements ICall {
   public int call(int i) {
      return i * 2;
   }
}

class Call2 implements ICall {
   public int call(int i) {
      return i * i;
   }
}

class MyFunction1 implements MyFunction {
   public int apply(int i) {
      return i;
   }
}

public class App {
   static class S1 {
      static public int f1() {
         return 0;
      }
   }

   public static int invoke(ICall doCall) {
      return doCall.call(5);
   }

   public static int invoke(int i, ICall doCall) {
      return doCall.call(i);
   }

   public static void applyAndPrint(int i, int j, ICall doCall) {
      for (int n = Math.min(i, j); n <= Math.max(i, j); n++) {
         System.out.println(doCall.call(n));
      }
   }

   public static void main(String[] args) throws Exception {
      // S1.f1();
      int n;
      boolean b;

      // #region ICall function als (objekt-) Parameter
      // {
      // int i;
      // i = invoke(new Call1());
      // System.out.println(i);
      // i = invoke(new Call2());
      // System.out.println(i);
      // }
      // #endregion

      // #region ICall function als (objekt-) Parameter plus weiterer Parameter
      // {
      // int i;
      // i = invoke(5, new Call1());
      // System.out.println(i);
      // i = invoke(5, new Call2());
      // }
      // #endregion

      // #region ICall function als (objekt-) Parameter anon
      // {
      // invoke(new ICall() {
      // public int call(int i) {
      // System.out.println("irgend was");
      // return i;
      // }
      // });
      // }
      // #endregion

      // #region ICall mit Lambda
      // {
      // ICall exp2 = (n) -> n * n;
      // applyAndPrint(8, 3, exp2);
      // //applyAndPrint(10, 20, (i) -> i * 2);
      // }
      // #endregion

      // #region applyAndPrint mit Lambda und anon
      // {
      // System.out.println("applyAndPrint mit Lambda");
      // applyAndPrint(10, 20, (i) -> i * 2);
      // System.out.println("applyAndPrint mit anonym");
      // applyAndPrint(10, 20, new ICall() {
      // @Override
      // public int call(int i) {
      // return i * 2;
      // }
      // });
      // }
      // #endregion

      // #region Prädikat
      {
         n = 10;

         Predicate<Integer> even = (i) -> i % 2 == 0;
         //Predicate<Integer> odd = (i) -> i % 2 != 0;
         b = even.test(n);

         // d.h:
         if (even.test(n))
            System.out.println("n ist gerade");
         // und
         if (n % 2 == 0)
            System.out.println("n ist gerade");
         // ist das gleiche,
         // nur even.test liest sich schöner und der Name sagt aus was man prüfen wollte

         System.out.printf("even.test (%d) : %b \n", n, b);
         System.out.printf("conditionateInput (%d) returns: %d", n, new MyFunctionExt() {
            public int apply(int i) {
               return i * i;
            }
         }.conditionateInput(even, n));
      }
      // #endregion

      { // xx

         n = 1;
         b = false;
      }
   }
}