package gestioneMesolaLibri.mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {

    public String autore;
    public String titolo;
    public int numeroPagine;
    public final double costoPagina = 0.05;
    public Genere tipologia;
    public LocalDate dataPubblicazione;
    public DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public boolean equals(Libro book) {
        return this.autore.equals(book.autore) && this.titolo.equals(book.titolo);
    }

    @Override
    public String toString() {
        return String.format("Autore: %s; Titolo: %s; Numero pagine: %d; Prezzo: %f; Genere: %s; Data: %s\n",
                autore, titolo, numeroPagine, numeroPagine * costoPagina, tipologia.toString(), dataPubblicazione.format(formattazioneData));
    }
}
