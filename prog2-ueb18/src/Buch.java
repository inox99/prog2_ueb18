public class Buch extends Artikel{
    
    String titel;
    String autor;
    String verlag;
    
    
    public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag){

        super(artikelNr, "Medien", bestand, preis);

        if(titel == null){
            throw new IllegalStateException("Kein Name angegeben");
        }
        if(autor == null){
            throw new IllegalStateException("Kein Autor angegeben");
        }
        if(verlag == null){
            throw new IllegalStateException("Kein Verlag angegeben");
        }

        this.autor = autor;
        this.titel = titel;
        this.verlag = verlag;
    }

    @Override
    public String getBeschreibung(){
        return autor + ": " + titel;
    }

    public String getTitel(){
        return titel;
    }

    public String getAutor(){
        return autor;
    }

    public String getVerlag(){
        return verlag;
    }

    @Override
    public String toString(){
        String s = String.format("Titel: %s Autor: %s Verlag: %s", titel, autor, verlag);
        return super.toString() + s;
    }

}
