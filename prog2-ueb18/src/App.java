import java.util.function.Consumer;
import java.util.function.Predicate;

public class App {
   public static void main(String[] args) throws Exception {
      Lager lager = new Lager(3);
      lager.legeAnArtikel(new CD(5000, 5, 3.44, "AC/DC", "titel", 5));
      lager.legeAnArtikel(new Buch(1000, 3, 5.80, "Autor1", "titel1", "Verlag1"));
      lager.legeAnArtikel(new Buch(1001, 4, 7.70, "Autor1", "titel2", "Verlag1"));

      lager.augebenBestandsListe();
      System.out.println("----------------------");

      // =====================================================================================================================
      //a)
      // java.util.function.BiPredicate<Artikel, Artikel> p = (a1, a2) -> a1.getBestand() > a2.getBestand();
      // java.util.function.BiPredicate<Artikel, Artikel> p = (a1, a2) -> a1.getPreis() < a2.getPreis();
      // Lager.augebenBestandsListe(lager.getSorted(p));

      // //=====================================================================================================================
      // b)
      // Consumer<Artikel> operation = a -> a.setBestand(a.getBestand() * 2);
      // lager.applyToArticles(operation);
      // lager.augebenBestandsListe();

      // =====================================================================================================================
      // c) Ueb18Fassade ...fehlt...

      // // =====================================================================================================================
      // // d)
      // Predicate<Artikel> p = a -> a.getBestand() >= 4;
      // Lager.augebenBestandsListe(lager.filter(p));

      // // =====================================================================================================================
      // // e) = kombination aus b) und d)

      // // =====================================================================================================================
      // // f) = kombination aus a) und d)

      // // =====================================================================================================================
      // // g)
      // Predicate<Artikel> b = a -> a.getBestand() < 4;
      // Predicate<Artikel> p = a -> a.getPreis() > 5;
      // Lager.augebenBestandsListe(lager.filterAll(b, p));

   }
}
