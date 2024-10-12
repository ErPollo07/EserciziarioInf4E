import java.util.Scanner;

public class Tosatti_4E_A002_ExceptionHandling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a, b, somma;

        int[] arr = {1, 1, 1, 1};

        /*
        try {
            for (int i = 0; i <= arr.length; i++) {
                System.out.println(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("si e' verificato un errore");
        }

        System.out.println("Il programma continua");
        */

        while (true) {
            try {
                System.out.println("inserire il primo numero");
                a = gestInteger(scanner);

                System.out.println("inserire il primo numero");
                b = gestInteger(scanner);

                System.out.println("La somma e': " + (a + b));

                break;
            } catch (Exception e) {
                System.out.println("inserimento fallito: " + e.getMessage() + "\n\t");
            }
        }
    }

    private static int gestInteger(Scanner scanner) throws Exception {
        int n;

        System.out.println("inserisci n: ");
        n = Integer.parseInt(scanner.next());

        if (n >= 0) {
            return n;
        } else {
            throw new Exception("Valore non valido");
        }
    }
}
