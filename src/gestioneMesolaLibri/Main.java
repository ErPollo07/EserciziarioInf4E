import frontScreen.FrontEnd;
import mensola.Libro;
import util.Tools;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String[] menuOptions = {
                "Mensola libri",
                "Inserimento",
                "Visualizza",
                "Modifica numero di pagine di un libro",
                "Cancella un libro",
                "Visuallizza libri di un autore",
                "Esci",
        };

        final int N = 5;
        Libro[] books = new Libro[N];
        int indexBooks = 0;
        boolean exit = false;

        // Modifica numero pagine
        Libro bookMod;
        String titleMod, authorMod;
        int indexMod, pageNumMod;

        // Cancella un libro
        String titleDel, authorDel;

        // Visuallizza libri di un autore
        String authorView;


        do {
            switch (Tools.menu(menuOptions, scanner)) {
                case 1:
                    if (indexBooks == N) {
                        System.out.println("Non c'e' piu' spazio");
                        break;
                    }

                    Libro newBook = FrontEnd.leggiLibro(scanner);

                    if (!validateNewBook(books, newBook)) {
                        System.out.println("\t<ATTENZIONE> Il libro non puo' avere titolo e autore ugali a un altro libro in raccolta.\n\tI dati sono stati scartati");
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

                case 3: /* Modifica numero pagine */

                    // Take title and author
                    System.out.println("Inserisci il titolo del libro a cui vuoi modificare le pagine: ");
                    titleMod = scanner.next();

                    System.out.println("Inserisci il nome dell'autore del libro a cui vuoi modificare le pagine: ");
                    authorMod = scanner.next();

                    // Get the index of the equal book
                    indexMod = get(books, titleMod, authorMod);
                    if (indexMod == -1) {
                        System.out.println("I dati inseriti (Titolo: " + titleMod + ", Autore: " + authorMod + ") non corrispondono a nessun libro in libreria.");
                        break;
                    }

                    bookMod = books[indexMod];

                    // Take the new number of pages

                    while (true) {
                        try {
                            System.out.println("Inserisci il numero di pagine: ");
                            pageNumMod = Integer.parseInt(scanner.next());

                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("\t<ATTENZIONE> Inserire solo numeri");
                        } catch (Exception e) {
                            System.out.println("\t<ATTENZIONE> Dato invalido");
                        }
                    }

                    // Modify the number of pages
                    bookMod.numeroPagine = pageNumMod;

                    break;

                case 4: /* Cancella un libro */
                    // Take title and author
                    System.out.println("Inserisci il titolo del libro a cui vuoi modificare le pagine: ");
                    titleDel = scanner.next();

                    System.out.println("Inserisci il nome dell'autore del libro a cui vuoi modificare le pagine: ");
                    authorDel = scanner.next();

                    if (delete(books, titleDel, authorDel)) {
                        System.out.println("Il libro e' stato eliminato");
                        indexBooks--;
                    } else {
                        System.out.println("Il libro non e' presente nella libreria");
                    }

                    break;
                case 5: /* Visuallizza libri di un autore */

                    System.out.println("Inserisci il nome dell'autore di cui vuoi vedere i libri: ");
                    authorView = scanner.next();

                    FrontEnd.viewAuthor(books, authorView);

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

            // If book is equal to a book in the array
            // return false because the new book isn't valid
            if (book.equals(newBook)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Cycle through all the books in the array.<br>
     * When it finds the books[i] equals to the bookToSearch (define in the scope), return i. <br>
     * If the method find nothing return -1.
     *
     * @param books  array to cicle
     * @param title  title of the book to search
     * @param author author of the book to search
     * @return The index if the bookToSearch is in the array else return -1
     */
    private static int get(Libro[] books, String title, String author) {
        Libro bookToSearch = new Libro();

        bookToSearch.titolo = title;
        bookToSearch.autore = author;

        // Cicle through all the books
        for (int i = 0; i < books.length && books[i] != null; i++) {
            // Check if the books[i] is equals to bookToSearch
            if (books[i].equals(bookToSearch)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * The method delete an element of {@code books} param.
     * The method search in the array, if the book with title and author
     * equals to the one passed as param, delete it and return true.
     * If there isn't the book return false.
     *
     * @param books array to search
     * @param title title of the book to delete
     * @param author author of the book to delete
     * @return true if the book can be deleted ; false if there isn't the book
     */
    private static boolean delete(Libro[] books, String title, String author) {

        Libro bookToDel = new Libro();

        bookToDel.titolo = title;
        bookToDel.autore = author;

        // Cycle through all the books
        for (int i = 0; i < books.length && books[i] != null; i++) {

            // Check if the books[i] is equals to bookToDel
            if (books[i].equals(bookToDel)) {
                for (int j = i; j < books.length - 1 && books[j] != null; j++) {
                    books[j] = books[j + 1];
                }

                return true;
            }
        }

        return false;
    }
}
