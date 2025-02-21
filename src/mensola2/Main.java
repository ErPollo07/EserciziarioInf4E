package mensola2;

import mensola2.libri.Libro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] mainMenu = {
                "Mensola",
                "Crea libro",
                "Visualizza libri",
                "Modifica libro",
                "Elimina libro",
                "Esci"
        };

        Mensola mensola = new Mensola(5);
        boolean exit = false;


        while (!exit) {
            switch (Tools.menu(mainMenu, scanner)) {
                // Crea
                case 1 -> {
                    if (!mensola.isAvaible()) {
                        System.out.println("\nSPAZIO MASSIMO RAGGIUNTO\n");
                        break;
                    }

                    String tipoDaLeggere;
                    Libro libroNuovo;

                    do {
                        System.out.println("Inserisci il tipo da leggere (romanzo/thriller/manuale): ");
                        tipoDaLeggere = scanner.nextLine();
                    } while (!tipoDaLeggere.equals("romanzo") && !tipoDaLeggere.equals("thriller") && !tipoDaLeggere.equals("manuale"));

                    if (tipoDaLeggere.equals("romanzo")) {
                        libroNuovo = FrontEnd.leggiManuale(scanner);
                    } else if (tipoDaLeggere.equals("thriller")) {
                        libroNuovo = FrontEnd.leggiThriller(scanner);
                    } else {
                        libroNuovo = FrontEnd.leggiManuale(scanner);
                    }

                    if (mensola.getMensola().contains(libroNuovo)) {
                        System.out.println("\nLE INFORMAZIONI INSERITE SONO GIA' PRESENTI.\nI DATI VERRANNO SCARTATI.\n");
                        break;
                    }

                    mensola.addLibro(libroNuovo);
                }
                // Visualizza
                case 2 -> {
                    mensola.getMensola().forEach(System.out::println);
                }
                // Modifica
                case 3 -> {
                    mensola.getMensola().forEach(System.out::println);

                    System.out.println("\nINSERISCI LE INFORMAZIONI DEL LIBRO CHE VUOI MODIFICARE\n");
                    Libro libro = FrontEnd.leggiLibro(scanner);

                    if (!mensola.getMensola().contains(libro)) {
                        System.out.println("\nIL LIBRO NON ESISTE\n");
                        break;
                    }

                    System.out.println("INSERISCI LE INFORMAZIONI DEL LIBRO");
                    Libro libro1 = FrontEnd.leggiLibro(scanner);

                    int index = mensola.getMensola().indexOf(libro);
                    mensola.remove(libro);
                    mensola.addLibro(libro1, index);
                }
                // Elimina
                case 4 -> {
                    Libro libro = FrontEnd.leggiLibro(scanner);

                    if (mensola.getMensola().remove(libro)) {
                        System.out.println("Libro eliminato con successo.");
                    } else {
                        System.out.println("Libro non esistente.");
                    }
                }
                // Esci
                default -> {
                    System.out.println("Salvataggio di dati in corso ...");
                    Saver.Csv.write("src/mensola/file/file", new ArrayList<>(mensola.getMensola().stream().map(Libro::toCsv).toList()));
                    Saver.Json.write("src/mensola/file/file", mensola.getMensola());
                    System.out.println("Uscita dal programma");
                    exit = true;
                }
            }
        }


        System.out.println("\nPROGRAMMA TERMINATO\n");
    }
}

