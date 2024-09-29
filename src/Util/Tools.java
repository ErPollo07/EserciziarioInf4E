package Util;

import java.util.Scanner;
public class Tools {
    private Tools() {}

    public static void clrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void wait(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int menu(String options[], Scanner scanner) {// parametri formali
        int scelta;

        do {
            // clrScr();
            for (int i = 0; i < options.length; i++) {
                System.out.print("-");
            }
            System.out.println();

            System.out.println(options[0]);

            for (int i = 0; i < options.length; i++) {
                System.out.print("-");
            }
            System.out.println();

            for (int i = 1; i < options.length; i++) {
                System.out.println("[" + i + "]" + " " + options[i]);
            }
            scelta = (Integer.parseInt(scanner.nextLine()));
            //tastiera.nextLine();

            if ((scelta < 1) || (scelta > options.length - 1)) {
                System.out.println("Opzione Sbagliata");
                // wait(2000);
            }
        }
        while ((scelta < 1) || (scelta > options.length - 1));
        //tastiera.nextLine();
        return scelta;
    }

}