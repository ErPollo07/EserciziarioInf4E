package gestioneMesolaLibri.frontScreen;

import gestioneMesolaLibri.mensola.Genere;
import gestioneMesolaLibri.mensola.Libro;
import util.Tools;

import java.time.LocalDate;
import java.util.Scanner;

public class FrontEnd {
    public static Libro leggiLibro(Scanner scanner) {
        Libro output = new Libro();

        System.out.println("inserire l'autore: ");
        output.autore = scanner.next();

        System.out.println("Inserire titolo: ");
        output.titolo = scanner.next();

        System.out.println("Numero di pagine: ");
        output.numeroPagine = Integer.parseInt(scanner.next());

        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Generi";
        for (int i = 0; i < generi.length; i++) {
            menuData[i + 1] = generi[i].toString();
        }
        int genereIndex;
        do {
            genereIndex = Tools.menu(menuData, scanner) - 1;
        } while (genereIndex == -1);
        output.tipologia = generi[genereIndex];

        while (true) {
            try {
                System.out.println("Inserisci la data di pubblicazione (dd-mm-yyyy): ");
                String dateInput = scanner.next();
                output.dataPubblicazione = LocalDate.parse(dateInput, output.formattazioneData);

                break;
            } catch (Exception e) {
                System.out.println("\t<ATTENZIONE> Valore data invalido.\n\tInserire una dato con formattazione specificata tra parentesi.");
            }
        }

        return output;
    }

    public static void viewAuthor(Libro[] books, String author) {
        for (int i = 0; i < books.length && books[i] != null; i++) {
            if (books[i].autore.equals(author)) {
                System.out.println(books[i].toString());
            }
        }
    }
}
