import java.util.Scanner;
//task 1

public class Reverse{
    public static void main(String[] args) {
        System.out.println("Hello! I reverse sentences. Please, write yours: ");
        Scanner scanner = new Scanner(System.in);
        String toScan1 = scanner.nextLine();


        String reversed = "";
        char additional1;


        for (int i = 0; i < toScan1.length(); i++){
            additional1 = toScan1.charAt(i);
            reversed = additional1 + reversed;
        }
        System.out.println(reversed);

// Nie spodobała mie się wydajność tej metody, więc poszukałam innej metody;
// i znalazłam konstrukcję StringBuilder;
        System.out.println("Hello again! I have a different code now!" +
                " Please, write your sentence: ");

        boolean ok;
        do {
            String toScan2 = scanner.nextLine();
            if (!toScan2.trim().isEmpty()) {
                ok = true;
                StringBuilder toReverse = new StringBuilder();

                toReverse.append(toScan2);
                toReverse.reverse();
                System.out.println(toReverse);

            } else {ok = false;
            System.out.println("Nie mam nic do pracy, spróbuj ponownie :)");}
        } while (!ok);
        scanner.close();

    }
}
