package mensola2.libri;

import java.util.Objects;

public class Libro {
    private String autore;
    private String titolo;
    private int nPagine;
    private static final double COSTOPAGINE = 0.05;

    public Libro(String autore, String titolo, int nPagine) {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
    }

    public Libro(Libro l){
        this.autore = l.getAutore();
        this.titolo = l.getTitolo();
        this.nPagine = l.getnPagine();
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

    public int getnPagine() {
        return nPagine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return nPagine == libro.nPagine && Objects.equals(autore, libro.autore) && Objects.equals(titolo, libro.titolo);
    }

    public String toCsv() {
        return String.format("%s;%s;%d;%s;%.2f", titolo, autore, nPagine, prezzo(nPagine, COSTOPAGINE));
    }

    @Override
    public String toString() {
        return String.format("titolo: %s; autore: %s; numero pagine: %d; costo Libro: %.2f", titolo, autore, nPagine, prezzo(nPagine, COSTOPAGINE));
    }
}