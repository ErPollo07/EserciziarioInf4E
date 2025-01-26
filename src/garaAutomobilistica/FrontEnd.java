package garaAutomobilistica;

import java.util.Scanner;

public class FrontEnd {

    public static Pilota inserisciPilota(Scanner scanner) {
        String nome, cognome, nazionalita;
        int eta;

        System.out.println("Inserisci nome: ");
        nome = scanner.nextLine();

        System.out.println("Inserisci cognome: ");
        cognome = scanner.nextLine();

        System.out.println("Inserisci nazionalita: ");
        nazionalita = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Inserisci eta: ");
                eta = Integer.parseInt(scanner.nextLine());

                if (eta < 0) {
                    throw new Exception("L'eta' deve essere positiva.");
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Devi inserire un numero intero.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return new Pilota(nome, cognome, nazionalita, eta);
    }
}
