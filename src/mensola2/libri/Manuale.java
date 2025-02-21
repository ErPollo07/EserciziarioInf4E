package mensola2.libri;

public class Manuale extends Libro {
    private String argomento;
    private Livello livello;

    public Manuale(String autore, String titolo, int nPagine, String argomento, Livello livello) {
        super(autore, titolo, nPagine);
        this.argomento = argomento;
        this.livello = livello;
    }

    public Manuale(Libro l, String argomento, Livello livello) {
        super(l);
        this.argomento = argomento;
        this.livello = livello;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public Livello getLivello() {
        return livello;
    }

    public void setLivello(Livello livello) {
        this.livello = livello;
    }
}
