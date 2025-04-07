import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//task 4


public class KalkulatorProsty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("I am a calculator. Enter an expression (e.g., 5+6):");

        String expression = scanner.nextLine().trim();

        List<Double> numbers = new ArrayList<>(); //for storing numbers;
        List<Character> operators = new ArrayList<>(); //for storing operators;

        String num = ""; //for building current number as a String;
        boolean negative = false; //flag to check if the number is negative

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Check for a minus sign at the start of a number or after an operator
            if (c == '-' && (i == 0 || "+-*/".indexOf(expression.charAt(i - 1)) != -1)) {
                negative = true;
                continue;  // skip adding '-' to the number
            }

            // Check if the character is part of a number, digit, decimal, or comma
            if (Character.isDigit(c) || c == '.') {
                num += c;
            }
            // Handle operators and store the number when encountered
            else if ("+-*/".indexOf(c) != -1) {
                if (negative) {
                    num = "-" + num; // prepend minus if the flag is set
                    negative = false; // reset the flag
                }
                numbers.add(Double.parseDouble(num));
                num = "";
                operators.add(c);
            }
        }

// Handle the last number
        if (negative) {
            num = "-" + num;
        }
        numbers.add(Double.parseDouble(num));

        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '*' || operators.get(i) == '/') {
                double result = (operators.get(i) == '*') ?
                        numbers.get(i) * numbers.get(i + 1) :
                        numbers.get(i) / numbers.get(i + 1);

                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }

        double finalResult = numbers.getFirst();
        for (int i = 0; i < operators.size(); i++) {
            finalResult = (operators.get(i) == '+') ?
                    finalResult + numbers.get(i + 1) :
                    finalResult - numbers.get(i + 1);
        }

        System.out.printf("Result: %10.2f", finalResult);
    }
}
