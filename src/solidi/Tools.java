package solidi;

import java.util.Scanner;

public class Tools {
    private Tools() {
    }

    public static void clrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int menu(String[] opzioni, Scanner scanner) {
        int scelta;

        do {
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " - " + opzioni[i]);
            }

            scelta = Integer.parseInt(scanner.nextLine());

            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
            }
        }
        while ((scelta < 1) || (scelta > opzioni.length - 1));

        return scelta;
    }
}