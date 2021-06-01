interface ICall {
   void call();
}

class call1 implements ICall {
   public void call() {
      System.out.println("call1");
   }
}

class call2 implements ICall {
   public void call() {
      System.out.println("call5");
   }
}

public class App {
   public static void call(ICall doCall) {
      doCall.call();
   }

   public static void main(String[] args) throws Exception {
      call(new call1());
      call(new call2());

      call(new ICall() {
         public void call() {
            System.out.println("irgend was");
         }
      });
   }
}
