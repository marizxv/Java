import java.util.Scanner;

public class KodowanieCezara {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        int letterShift = shift % 26;
        int digitShift = shift % 10;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char encryptedChar = (char) ((c - base + letterShift + 26) % 26 + base);
                result.append(encryptedChar);
            } else if (Character.isDigit(c)) {
                char encryptedDigit = (char) ((c - '0' + digitShift + 10) % 10 + '0');
                result.append(encryptedDigit);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        int letterShift = shift % 26;
        int digitShift = shift % 10;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char decryptedChar = (char) ((c - base - letterShift + 26) % 26 + base);
                result.append(decryptedChar);
            } else if (Character.isDigit(c)) {
                char decryptedDigit = (char) ((c - '0' - digitShift + 10) % 10 + '0');
                result.append(decryptedDigit);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence to encrypt:");
        String sentence = scanner.nextLine();

        int shift = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter the shift code (positive or negative integer):");
            if (scanner.hasNextInt()) {
                shift = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter a whole number.");
                scanner.next(); // discard invalid input
            }
        }

        String encrypted = encrypt(sentence, shift);
        System.out.println("Encrypted sentence: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted sentence: " + decrypted);

        scanner.close();
    }
}
