package garaAutomobilistica;

import garaAutomobilistica.util.Tools;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] mainMenu = {
                "GARA AUTOMOBILISTICA",
                "Inserisci pilota",
                "Corri gara",
                "Salva risultato",
                "Esci"
        };

        ArrayList<Pilota> piloti = new ArrayList<>();
        boolean exit = true;

        do {
            switch (Tools.menu(mainMenu, scanner)) {

                case 1 -> {
                    Pilota newPilota = FrontEnd.inserisciPilota(scanner);

                    if (piloti.contains(newPilota)) {
                        System.out.println("Il pilota esiste gia'. I dati sono stati scartati.");
                        break;
                    }

                    piloti.add(newPilota);
                }
                // Run race
                case 2 -> {
                    Gara.corriGara(piloti);

                    for (Pilota pilota : Gara.risultato) {
                        System.out.println(pilota.getNome() + " " + pilota.getCognome());
                    }
                }
                // Save into file
                case 3 -> {
                    String filename = "";

                    do {
                        System.out.println("Inserisci nome del file in cui vuoi salvare il risultato della gara: ");
                        filename = scanner.nextLine();
                    } while (filename.isEmpty());

                    ArrayList<String> pilotiCsv = (ArrayList<String>) piloti.stream().map(Pilota::toCsv).collect(Collectors.toCollection(ArrayList<String>::new));

                    Saver.Csv.write(filename, pilotiCsv);
                    Saver.Json.write(filename, Gara.risultato);
                }
                default -> {
                    exit = false;
                }
            }
        } while (exit);
    }
}
