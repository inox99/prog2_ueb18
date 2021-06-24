import java.util.function.Predicate;

public interface MyFunctionExt extends MyFunction {
   default int conditionateInput(Predicate<Integer> p, int n) {
      if (p.test(n))
         return apply(n);
      return 0;
   }
}
