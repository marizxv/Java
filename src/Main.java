import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x=0,y=0;
        String linia;
        boolean ok;
        do {
            try {
                ok=true;
                System.out.print("\nPodaj pierwszą liczbę: ");
                linia=scanner.nextLine();
                x=Integer.parseInt(linia);
            }
            catch (InputMismatchException | NumberFormatException ex) {ok=false;}

        } while (!ok);

        do {
            try {
                ok=true;
                System.out.print("\nPodaj drugą liczbę: ");
                linia=scanner.nextLine();
                y=Integer.parseInt(linia);
            }
            catch (InputMismatchException | NumberFormatException ex) {ok=false;}

        } while (!ok);

        System.out.printf("Suma %d i %d to %d", x, y, x+y);
    }
}
