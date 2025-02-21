package mensola2.libri;

public class Romanzo extends Libro {
    private String genereLetterario;

    public Romanzo(String autore, String titolo, int nPagine, String genereLetterario) {
        super(autore, titolo, nPagine);
        this.genereLetterario = genereLetterario;
    }

    public Romanzo(Libro l, String genereLetterario) {
        super(l);
        this.genereLetterario = genereLetterario;
    }
}
