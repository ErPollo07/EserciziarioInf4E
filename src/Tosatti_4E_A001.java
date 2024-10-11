import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static util.Tools.menu;

public class Tosatti_4E_A001 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        final String[] strings = {
                "NUMERI RANDOM",
                "Genera numeri casuali",    // 1
                "Visualizza",               // 2
                "Cerca numero",             // 3
                "Cancella numero con 0",    // 4
                "Cancella numero",          // 5
                "Ordina (selection)",       // 6
                "Esci",
        };


        final int NMAX = 20, RANGE = 10;
        int[] numbers = new int[NMAX];
        boolean exit = true;

        do {
            switch (menu(strings, scanner)) {
                case 1:
                    numbers = generate(RANGE, NMAX);

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
                case 4:

                    System.out.println("Inserisci il numero che vuoi sostituire con 0: ");
                    int numberToSearch = Integer.parseInt(scanner.next());

                    deleteNumberWithZero(numbers, numberToSearch);

                    break;
                case 5:

                    System.out.println("Inserisci il numero che vuoi cancellare: ");
                    int deleteNumber = Integer.parseInt(scanner.next());

                    deleteNumber(numbers, deleteNumber);

                    break;
                case 6:

                    selectionSort(numbers);

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
            } while (check[n[i] - 1]);

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

    private static void deleteNumberWithZero(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                arr[i] = 0;
                break;
            }
        }
    }

    private static void deleteNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                for (int j = i; j < arr.length - 1; i++) {
                    arr[j] = arr[j + 1];
                }

                break;
            }
        }
    }

    private static void selectionSort(int[] arr) {

        int currentPos = 0;

        for (int i = 0; i < arr.length; i++) {
            currentPos = i;

            // find the minimun number
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[currentPos]) {
                    currentPos = j;
                }
            }

            if (currentPos != i) {
                int t = arr[i];
                arr[i] = arr[currentPos];
                arr[currentPos] = t;
            }
        }
    }
}