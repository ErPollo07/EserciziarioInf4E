package mensola2.libri;

public class Thriller extends Libro {
    private Genere genere;

    public Thriller(String autore, String titolo, int nPagine, Genere genere) {
        super(autore, titolo, nPagine);
        this.genere = genere;
    }

    public Thriller(Libro l, Genere genere) {
        super(l);
        this.genere = genere;
    }
}
