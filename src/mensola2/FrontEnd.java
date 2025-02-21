package mensola2;

import mensola2.libri.*;

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

        return new Libro(autore, titolo, nPagine);
    }

    public static Manuale leggiManuale(Scanner scanner) {
        Manuale manuale;
        String argomento, livelloString;
        Livello livello;
        Libro libro = leggiLibro(scanner);

        do {
            System.out.println("Inserisci argomneto: ");
            argomento = scanner.nextLine();
        } while (argomento.isEmpty());

        do {
            System.out.println("Inserisci il livello (base, medio, avanzato): ");
            livelloString = scanner.nextLine();
        } while(livelloString.isEmpty());

        while (true) {
            try {
                System.out.println("Inserisci il livello (base, medio, avanzato): ");
                livelloString = scanner.nextLine();

                livello = Livello.valueOf(livelloString.toUpperCase());

                break;
            } catch (Exception e) {
                System.out.println("Valore errato");
            }
        }

        manuale = new Manuale(libro, argomento, livello);

        return manuale;
    }

    public static Thriller leggiThriller(Scanner scanner) {
        Thriller thriller;
        String genereString;
        Genere genere;
        Libro libro = leggiLibro(scanner);

        while (true) {
            try {
                System.out.println("Inserire il genere (fantastico, horror, serietv): ");
                genereString = scanner.nextLine();

                genere = Genere.valueOf(genereString.toUpperCase());

                break;
            } catch (Exception e) {
                System.out.println("Valore errato");
            }
        }

        thriller = new Thriller(libro, genere);

        return thriller;
    }

    public static Romanzo leggiRomanzo(Scanner scanner) {
        Romanzo romanzo;
        String genereLetterario;
        Libro libro = leggiLibro(scanner);

        do {
            System.out.println("inserisci il genere letterario: ");
            genereLetterario = scanner.nextLine();
        } while (genereLetterario.isEmpty());

        romanzo = new Romanzo(libro, genereLetterario);

        return romanzo;
    }
}
