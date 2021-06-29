import java.lang.reflect.Array;

public class GList<E> {
   class G {
      E e;
      protected G prev;
      protected G next;

      public G(E e) {
         this.e = e;
         prev = next = null;
      }
   }

   private int size;
   private G first;
   private G last;

   public GList() {
      this.clear();
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public void clear() {
      size = 0;
      first = null;
   }

   public <T> T[] toArray(T[] a) {
      if (a == null)
         throw new NullPointerException();
      if (a.length < size)
         a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
      if (!isEmpty()) {
         G g = first;
         for (int i = 0; i < a.length; i++) {
            if (g == null)
               a[i] = null;
            else
               a[i] = (T) g.e;
            g = g.next;
         }
      }
      return a;
   }

   public boolean add(E e) {
      G g = new G(e);
      if (isEmpty()) {
         first = last = g;
      } else {
         g.prev = last;
         last.next = g;
      }
      last = g;
      size++;
      return true;
   }

   public boolean contains(Object o) {
      for (G g = first; g != null; g = g.next) {
         if (g.e.equals(o))
            return true;
      }
      return false;
   }

   public boolean remove(Object o) {
      for (G g = first; g != null; g = g.next) {
         if (g.e.equals(o)) {
            if (g == first) {
               first = g.next;
            } else {
               g.prev.next = g.next;
            }
            size--;
            g = null;
            return true;
         }
      }
      return false;

   }
}