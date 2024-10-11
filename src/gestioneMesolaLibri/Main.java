package gestioneMesolaLibri;

import gestioneMesolaLibri.frontScreen.FrontEnd;
import gestioneMesolaLibri.mensola.Libro;
import util.Tools;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String[] menuOptions = {
                "Mensola libri",
                "Inserimento",
                "Visualizza",
                "Esci",
        };

        final int N = 5;
        Libro[] books = new Libro[N];
        int indexBooks = 0;
        boolean exit = false;
        Objects aa;

        do {
            switch (Tools.menu(menuOptions, scanner)) {
                case 1:
                    if (indexBooks == N) {
                        System.out.println("Non c'e' piu' spazio");
                        break;
                    }

                    Libro newBook = FrontEnd.leggiLibro(scanner);

                    if (!validateNewBook(books, newBook)) {
                        System.out.println("\t<ATTENZIONE> Il libro non puo' avere titolo e autore ugali a un altro libro in raccolta.\n\t I dati sono stati scartati");
                        break;
                    }

                    books[indexBooks++] = newBook;

                    break;
                case 2:

                    for (Libro book : books) {
                        if (book == null) {
                            break;
                        }

                        System.out.println(book.toString());
                    }

                    break;
                default:
                    exit = true;
            }
        } while (!exit);
    }

    private static boolean validateNewBook(Libro[] books, Libro newBook) {
        for (Libro book : books) {
            if (book == null) {
                return true;
            }

            if (book.equals(newBook)) {
                return false;
            }
        }

        return true;
    }
}
