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

public class App {
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
      // --------------------------------------------------------
      {
         int i;
         i = invoke(new Call1());
         System.out.println(i);
         i = invoke(new Call2());
         System.out.println(i);
      }
      // // --------------------------------------------------------
      // {
      // int i;
      // i = invoke(5, new Call1());
      // System.out.println(i);
      // i = invoke(5, new Call2());
      // }
      // // --------------------------------------------------------
      // {
      // invoke(new ICall() {
      // public int call(int i) {
      // System.out.println("irgend was");
      // return i;
      // }
      // });
      // }
      // // --------------------------------------------------------
      // {
      // ICall exp2 = (n) -> n * n;
      // applyAndPrint(8, 3, exp2);
      // //applyAndPrint(10, 20, (i) -> i * 2);
      // }
   }
   // ICall
}
