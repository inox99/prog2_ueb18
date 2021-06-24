public class CD extends Artikel {

    private String interpret;
    private String titel;
    private int anzahlTitel;

    CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, "Medien", bestand, preis);

        if (interpret == null) {
            throw new IllegalArgumentException("Kein Interpret");
        }
        if (titel == null) {
            throw new IllegalArgumentException("Kein Titel");
        }
        if (anzahlTitel < 1) {
            throw new IllegalArgumentException("Keine Titel");
        }

        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;
    }

    @Override
    public String getBeschreibung() {
        return interpret + ": " + titel;
    }

    public String getTitel() {
        return titel;
    }

    public String getInterpret() {
        return interpret;
    }

    public int getAnzahlTitel() {
        return anzahlTitel;
    }

    public String toString() {
        String s = String.format("Titel: %s Interpret: %s Anzahl Musiktitel: %d", titel, interpret, anzahlTitel);
        return super.toString() + s;
    }

}