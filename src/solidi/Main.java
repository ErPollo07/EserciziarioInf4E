package solidi;

import java.util.Scanner;

/*
Completare l'esercizio visto in laboratorio che implementa:
una classe astratta Solido con metodi astratti per calcolare volume e superficie;due classi concrete: Cubo e Sfera che estendono Solido
Realizzare una classe GestoreSolidi che gestisce una collezione di solidi usando ArrayList.La classe tramite un menu interattivo che permette di:
Inserire un nuovo cuboInserire una nuova sferaVisualizzare tutti i solidi inseriti.
Implementare il polimorfismo
Rispondere alle seguenti domande:
come può essere utilizzato il polimorfismo in questo esercizio?
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] menu = {
                "Solidi",
                "Inserisci cubo",
                "Inserisci sfera",
                "Visualizza lista",
                "Esci"
        };

        GestoreSolidi gestoreSolidi = new GestoreSolidi(5);

        boolean _continue = true;

        do {
            switch (Tools.menu(menu, scanner)) {
                case 1 -> {
                    if (gestoreSolidi.isFull()) {
                        System.out.println("Capienza massima raggiunta.");
                        break;
                    }

                    double lato;

                    while (true) {
                        try {
                            System.out.println("Inserisci lato del cubo: ");
                            lato = Double.parseDouble(scanner.nextLine());

                            break;
                        } catch (Exception e) {
                            System.out.println("Input non valido");
                        }
                    }

                    gestoreSolidi.add(new Cubo(lato));
                }
                case 2 -> {
                    if (gestoreSolidi.isFull()) {
                        System.out.println("Capienza massima raggiunta.");
                        break;
                    }

                    double raggio;

                    while (true) {
                        try {
                            System.out.println("Inserisci il raggio: ");
                            raggio = Double.parseDouble(scanner.nextLine());

                            break;
                        } catch (Exception e) {
                            System.out.println("Input non valido");
                        }
                    }

                    gestoreSolidi.add(new Sfera(raggio));
                }
                case 3 -> {
                    gestoreSolidi.getSolidi().forEach(System.out::println);
                }
                case 4 -> {
                    gestoreSolidi.getSolidi().forEach(s -> {
                        if (s instanceof Cubo) {
                            System.out.println(s.toString() + " è un cubo");
                        } else {
                            System.out.println(s.toString() + " è una sfera");
                        }
                    });
                }
                default -> {
                    _continue = false;
                }
            }
        } while (_continue);
    }
}
