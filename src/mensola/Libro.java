package mensola;

import java.util.Objects;

public class Libro {
    private String autore;
    private String titolo;
    private int nPagine;
    private Genere tipo;
    private static final double COSTOPAGINE = 0.05;

    public Libro(String autore, String titolo, int nPagine, Genere tipo) {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
        this.tipo = tipo;
    }

    public Libro(Libro l){
        this.autore = l.getAutore();
        this.titolo = l.getTitolo();
        this.nPagine = l.getnPagine();
        this.tipo = l.getTipo();
    }

    public static double prezzo(int nPagine, final double COSTOPAGINE){
        return nPagine * COSTOPAGINE;
    }

    public String getAutore() {
        return autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public Genere getTipo() {
        return tipo;
    }

    public int getnPagine() {
        return nPagine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return nPagine == libro.nPagine && Objects.equals(autore, libro.autore) && Objects.equals(titolo, libro.titolo) && tipo == libro.tipo;
    }

    public String toCsv() {
        return String.format("%s;%s;%d;%s;%.2f", titolo, autore, nPagine, tipo, prezzo(nPagine, COSTOPAGINE));
    }

    @Override
    public String toString() {
        return String.format("titolo: %s; autore: %s; numero pagine: %d; tipo: %s, costo Libro: %.2f", titolo, autore, nPagine, tipo, prezzo(nPagine, COSTOPAGINE));
    }
}