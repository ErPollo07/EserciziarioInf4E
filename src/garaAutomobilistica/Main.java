package garaAutomobilistica;

import garaAutomobilistica.util.Tools;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] mainMenu = {
                "GARA AUTOMOBILISTICA",
                "Inserisci pilota",
                "Esci"
        };

        ArrayList<Pilota> piloti = new ArrayList<>();
        boolean exit = true;

        do {
            switch (Tools.menu(mainMenu, scanner)) {
                case 1 -> {
                    Pilota newPilota = FrontEnd.getPilota(scanner);

                    if (piloti.contains(newPilota)) {
                        System.out.println("Il pilota esiste gia'. I dati sono stati scartati.");
                        break;
                    }

                    piloti.add(newPilota);
                }
                default -> {
                    exit = false;
                }
            }
        } while (exit);
    }
}
