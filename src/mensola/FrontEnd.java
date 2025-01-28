package mensola;

import java.util.Arrays;
import java.util.Scanner;

public class FrontEnd {

    public static Libro leggiLibro(Scanner scanner) {

        String autore, titolo, genereStr;
        int nPagine = 1;
        boolean nPagineIsCorrect = false;
        Genere genere;

        do {
            System.out.println("Inserisci autore: ");
            autore = scanner.nextLine();
            System.out.println("Inserisci titolo: ");
            titolo = scanner.nextLine();
        } while (autore.isEmpty() || titolo.isEmpty());

        do {
            try {
                System.out.println("Inserisci numero delle pagine: ");
                nPagine = Integer.parseInt(scanner.nextLine());

                nPagineIsCorrect = nPagine > 0;
            } catch (Exception e) {
                System.out.println("\nVALORE INVALIDO\n");
                nPagineIsCorrect = false;
            }
        } while (!nPagineIsCorrect);

        while (true) {
            try {
                System.out.println("Inserisci il genere (" + Arrays.toString(Genere.values()) + "): ");
                genereStr = scanner.nextLine();

                genere = Genere.valueOf(genereStr.toUpperCase());

                break;
            } catch (Exception e) {
                System.out.println("IL VALORE INSERITO A GENERATO UN'ECCEZIONE");
            }
        }

        return new Libro(autore, titolo, nPagine, genere);
    }
}
