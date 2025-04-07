import java.util.Scanner;
//task 2

public class EnterZamiastSpacji {
    public static void main(String[] args) {
        System.out.println("Zamieniam spacji na Enter, proszę wprowadzić zdanie: ");
        Scanner scanner1 = new Scanner(System.in);
        String line = scanner1.nextLine();
        String line2 = line.replaceAll(" ", "\n");

        System.out.println(line2);

    }
}
