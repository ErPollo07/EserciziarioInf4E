import java.util.Scanner;

public class Tosatti_4E_A003_Division {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int a = 0, b = 0;
        double d;

        while (true) {
            try {
                System.out.println("Inserisci a: ");
                a = Integer.parseInt(scanner.next());

                System.out.println("Inserisci b: ");
                b = Integer.parseInt(scanner.next());

                if (b == 0) {
                    throw new Exception("Can't divide number with 0");
                }

                d = (double) a / b;

                System.out.println("Divisione: " + d);

                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid number");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println("#################################");
        System.out.println("            METODO               ");
        System.out.println("#################################");

        while (true) {
            try {
                System.out.println("Inserisci a: ");
                a = Integer.parseInt(scanner.next());

                System.out.println("Inserisci b: ");
                b = Integer.parseInt(scanner.next());

                d = divisione(a, b);

                System.out.println("Divisione: " + d);

                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid number");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static double divisione(int a, int b) throws Exception {

        if (b == 0) {
            throw new Exception("Can't divide number with 0");
        }

        return (double) a / b;
    }
}
