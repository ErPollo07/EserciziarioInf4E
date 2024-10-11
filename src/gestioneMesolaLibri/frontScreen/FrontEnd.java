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
        for (int i = 0; i < generi.length; i++) {
            menuData[i + 1] = generi[i].toString();
        }
        int genereIndex = Tools.menu(menuData, scanner) - 1;
        output.tipologia = generi[genereIndex];

        // todo put try catch per il local date
        System.out.println("Inserisci la data di pubblicazione (dd-mm-yyyy): ");
        String dateInput = scanner.next();
        output.dataPubblicazione = LocalDate.parse(dateInput, output.formattazioneData);


        return output;
    }
}
