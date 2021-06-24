import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lager {

   private Artikel[] lager;

   public Lager(int dimension) {
      if (dimension < 0) {
         throw new IllegalArgumentException();
      } else {
         lager = new Artikel[dimension];
      }
   }

   public Lager() {
      lager = new Artikel[10];
   }

   public int pruefIndex() {
      for (int i = 0; i < lager.length; i++) {
         if (lager[i] == null) {
            return i;
         }
      }
      throw new IllegalArgumentException();
   }

   public Artikel[] getSorted(java.util.function.BiPredicate<Artikel, Artikel> predicate) {
      Artikel[] lager_ = lager.clone();
      Arrays.sort(lager_, new Comparator<Artikel>() {
         @Override
         public int compare(Artikel a1, Artikel a2) {
            if (a1 == null || a2 == null)
               return 0;
            return predicate.test(a1, a2) ? -1 : 1;
         }
      });
      return lager_;
   }

   public void applyToArticles(Consumer<Artikel> operation) {
      for (Artikel artikel : lager) {
         if (artikel != null)
            operation.accept(artikel);
      }
   }

   public List<Artikel> filter(Predicate<Artikel> predicate) {
      List<Artikel> artikels = new ArrayList<Artikel>();
      for (Artikel artikel : lager) {
         if (artikel != null) {
            if (predicate.test(artikel)) {
               artikels.add(artikel);
            }
         }
      }
      return artikels;
   }

   @SafeVarargs
   public final List<Artikel> filterAll(Predicate<Artikel>... predicates) {
      List<Artikel> artikels = new ArrayList<Artikel>();
      for (Artikel artikel : lager) {
         if (artikel != null) {
            if (predicates != null) {
               for (Predicate<Artikel> predicate : predicates) {
                  if (!predicate.test(artikel)) {
                     break;
                  }
               }
            }
            artikels.add(artikel);
         }
      }
      return artikels;
   }

   public void legeAnArtikel(Artikel artikel) {
      try {
         if (artikel != null) {
            lager[pruefIndex()] = artikel;
         } else {
            throw new IllegalStateException("Kein Artikel vorhanden.");
         }
      } catch (Exception e) {
         System.out.println(e.toString());
      }
   }

   public void entferneArtikel(int artikelNr) {
      for (int i = 0; i < lager.length; i++) {
         if (lager[i].getArtikelNr() == artikelNr && lager[i] != null) {
            for (int j = i + 1; j < lager.length; i++) {
               lager[j - 1] = lager[j];
            }
            lager[lager.length - 1] = null;
         }
      }
   }

   public void bucheZugang(int artikelNr, int menge) {
      for (Artikel artikel : lager) {
         if (artikel.getArtikelNr() == artikelNr) {
            artikel.bucheZugang(menge);
         }
      }
   }

   public void bucheAbgang(int artikelNr, int menge) {
      for (Artikel artikel : lager) {
         if (artikel.getArtikelNr() == artikelNr) {
            artikel.bucheAbgang(menge);
            ;
         }
      }
   }

   public void aenderePreisAllerArtikel(double prozent) {
      for (Artikel artikel : lager) {
         if (artikel != null) {
            artikel.aenderePreis(prozent);
         }
      }
   }

   public int getArtikelAnzahl() {
      int i = 0;
      for (Artikel artikel : lager) {
         if (artikel != null) {
            i++;
         }
      }
      return i;
   }

   public int getLagerGroesse() {
      int i = lager.length;
      return i;
   }

   public Artikel getArtikel(int artikelNr) {
      for (Artikel artikel : lager) {
         if (artikel != null && artikel.getArtikelNr() == artikelNr) {
            return artikel;
         }
      }
      return null;
   }

   public boolean lagerVoll() {
      boolean b = true;
      if (getArtikelAnzahl() < getLagerGroesse()) {
         b = false;
      }
      return b;
   }

   public void augebenBestandsListe() {
      Lager.augebenBestandsListe(lager);
   }

   public static void augebenBestandsListe(List<Artikel> artikels) {
      Lager.augebenBestandsListe(artikels.toArray(new Artikel[artikels.size()]));
   }

   public static void augebenBestandsListe(Artikel[] lager) {
      String s = ("Artikelnummer \t Beschreibung \t Preis \t Bestand \t Gesamtpreis\n");
      double gesamtPreis = 0;
      for (Artikel artikel : lager) {
         if (artikel != null) {
            gesamtPreis += artikel.getBestand() * artikel.getPreis();
         }

         s += String.format("%d \t %s \t %f \t %d \t %f \n", artikel.getArtikelNr(), artikel.getBeschreibung(),
               artikel.getPreis(), artikel.getBestand(), artikel.getBestand() * artikel.getPreis());
      }
      s += ("Gesamtpreis: " + gesamtPreis);
      System.out.println(s);
   }

}
