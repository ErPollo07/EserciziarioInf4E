package provaVerifica_09_11_2024;

import provaVerifica_09_11_2024.util.Tools;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] menu = {
                "LUNA PARK",
                "Aggiungi persona che entra",
                "Persona entra in una giostra",
                "Visualizza data e ora",
                "Esce una persona",
                "Esci",
        };

        ArrayList<Bigletto> biglietti = new ArrayList<>();
        final int MAX_PERSONE = 5;
        boolean exit = true;

        int numeroRandom;

        do {
            switch (Tools.menu(menu, scanner)) {
                /* Aggiungi persona che entra */
                case 1 -> {
                    if (biglietti.size() != MAX_PERSONE) {
                        Bigletto bigletto = new Bigletto();

                        // Generate the random ticket number
                        // until doesn't match the number of another
                        do {
                            numeroRandom = random.nextInt(0, 6);
                        } while (!bigliettoValido(numeroRandom, biglietti));

                        bigletto.numeroBiglietto = numeroRandom;
                        bigletto.tempoDiEntrata = LocalTime.now();

                        biglietti.add(bigletto);

                        System.out.println("Persona aggiunta con questo numero: " + numeroRandom);
                    } else {
                        System.out.println("Non ci sono piu' posti");
                    }
                }

                /* Persona entra in una giostra */
                case 2 -> {
                    // Get the tickets number in strings array ready to be printed in Tools.menu method
                    String[] numeriBiglietti = numeroBigliettiToString(biglietti);

                    // print a menu with the array of strings created before
                    // and get the ticket at the returned number from Tools.menu method
                    // subtract 1 from it because the menu starts counting form 1 and not form 0
                    Bigletto bigliettoScelto = biglietti.get(Tools.menu(numeriBiglietti, scanner) - 1);

                    // get the attraction of index returned from Tools.menu method
                    Giostra giostraScelta = Giostra.values()[Tools.menu(giostreToString(), scanner) - 1];

                    // Add the attraction to the attractions array in the ticket
                    bigliettoScelto.giostreFatte.add(giostraScelta);

                    // Add the date and time of the entrance in the attraction
                    bigliettoScelto.dataDiEntrataInGiostra.add(LocalDate.now());
                    bigliettoScelto.tempoDiEntrataInGiostra.add(LocalTime.now());
                }

                /* Visualizza data e ora */
                case 3 -> {
                    // Get the tickets number in strings array ready to be printed in Tools.menu method
                    String[] numeriBiglietti = numeroBigliettiToString(biglietti);

                    Bigletto bigliettoScelto = biglietti.get(Tools.menu(numeriBiglietti, scanner) - 1);

                    // get the attraction of index returned from Tools.menu method
                    Giostra giostraScelta = Giostra.values()[Tools.menu(giostreToString(), scanner) - 1];

                    // Get the position in the arrayList of doneAttraction of the selected attraction
                    int indexGiostra = 0;
                    for (Giostra giostra : bigliettoScelto.giostreFatte) {
                        if (giostra.equals(giostraScelta)) {
                            indexGiostra = bigliettoScelto.giostreFatte.indexOf(giostra);

                            break;
                        }
                    }

                    LocalDate data = bigliettoScelto.dataDiEntrataInGiostra.get(indexGiostra);
                    LocalTime time = bigliettoScelto.tempoDiEntrataInGiostra.get(indexGiostra);

                    System.out.println("La data di entrata e': " + data.getDayOfMonth() + "/" + data.getMonth() + "/" + data.getYear());
                    System.out.println("Il tempo di entrata e': " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
                }

                /* Esce una persona */
                case 4 -> {
                    if (!biglietti.isEmpty()) {
                        // Get the tickets number in strings array ready to be printed in Tools.menu method
                        String[] numeriBiglietti = numeroBigliettiToString(biglietti);

                        Bigletto bigliettoScelto = biglietti.get(Tools.menu(numeriBiglietti, scanner) - 1);

                        Duration duration = Duration.between(bigliettoScelto.tempoDiEntrata, LocalTime.now());

                        long hours = duration.toHours();
                        long minutes = duration.toMinutes() % 60; // minuti residui dopo le ore
                        long seconds = duration.getSeconds() % 60; // secondi residui dopo i minuti

                        System.out.println("Il tempo trascorso da questa persona nel parco e': " + hours + ":" + minutes + ":" + seconds);

                        biglietti.remove(bigliettoScelto);
                    } else {
                        System.out.println("Non c'e' nessuno nel Luna Park");
                    }
                }

                default -> exit = false;
            }
        } while (exit);
    }

    private static boolean bigliettoValido(int numero, ArrayList<Bigletto> bigletti) {

        for (Bigletto bigletto : bigletti) {
            if (numero == bigletto.numeroBiglietto) {
                return false;
            }
        }

        return true;
    }

    /*
    * Returns string array of giostre to be printed in Tools.menu method
    * */
    private static String[] giostreToString() {
        String[] giostreString = new String[Giostra.values().length + 1];
        int index = 1;
        Giostra[] giostre = Giostra.values();

        giostreString[0] = "GIOSTRE DISPONIBILI";

        for (Giostra giostra : giostre) {
            giostreString[index++] = giostra.name();
        }

        return giostreString;
    }

    /*
     * Returns string array of tickets number to be printed in Tools.menu method
     * */
    private static String[] numeroBigliettiToString(ArrayList<Bigletto> bigletti) {
        String[] numeriBiglietti = new String[bigletti.size() + 1];
        numeriBiglietti[0] = "NUMERO DEL BIGLIETTO";

        // Transform the numbers of the tickets into an array of strings
        bigletti.forEach(bigletto -> {
            numeriBiglietti[bigletti.indexOf(bigletto) + 1] = String.valueOf(bigletto.numeroBiglietto);
        });

        return numeriBiglietti;
    }
}
