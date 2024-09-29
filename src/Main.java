import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static Util.Tools.menu;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        final String[] strings = {
                "NUMERI RANDOM",
                "Genera numeri casuali",
                "Inserimento",
                "Esci",
        };


        final int NMAX = 53, RANGE = 100;
        int[] numbers = new int[NMAX];
        boolean exit = true;

        do {
            switch (menu(strings, scanner)) {
                case 1:
                    numbers = generateWithoutDuplicate(RANGE, NMAX);

                    System.out.println("Array = " + Arrays.toString(numbers));

                    break;
                case 2:

                    view(numbers, 5);

                    break;

                case 3:

                    System.out.println("Che numero vuoi cercare: ");
                    int searchFor = Integer.parseInt(scanner.next());

                    // check if is in range
                    int pos;
                    if ((pos = findNumber(numbers, searchFor)) != -1) {
                        System.out.println("Numero trovato in pos : " + pos);
                    } else {
                        System.out.println("Numero non trovato.");
                    }

                    break;

                default:
                    exit = false;
                    break;
            }
        } while (exit);
    }

    private static int[] generate(int range, int numbersToGenerate) {
        int[] n = new int[numbersToGenerate];

        for (int i = 0; i < numbersToGenerate; i++) {
            n[i] = random.nextInt(range);
        }

        return n;
    }

    private static int[] generateWithoutDuplicate(int range, int numbersToGenerate) {
        int[] n = new int[numbersToGenerate];
        boolean[] check = new boolean[numbersToGenerate];

        for (int i = 0; i < numbersToGenerate; i++) {
            do {
                // Generate numbers
                n[i] = random.nextInt(range);

                // check if the number is already insert
            } while (check[n[i]]);

            check[i] = true;
        }

        return n;
    }

    private static void view(int[] arr, int numberEveryRow) {
        int i = 0;

        System.out.print("[");

        for (int number : arr) {
            System.out.print(number + " ");

            if (++i == numberEveryRow) {
                System.out.print("\n");

                i = 0;
            }
        }

        System.out.print("]\n");
    }

    private static int findNumber(int[] arr, int targetNumber) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == targetNumber) return i;
        }

        return -1;
    }
}

/*
25/09/2024 : ADD method to generate numbers without duplicates ; ADD method to view arrays of numbers in rows
 */