import java.util.Scanner;
// task 5
// Zmęczyłam się myśleć po polsku i ciągle sobie tłumaczyć zdania;
// więc od tego zadania całość będzie w języku angielskim. Dziękuję za rozumienie;

public class KalkulatorZMeni {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        double num1, num2, result;

        while (true) {
            // Display menu
            System.out.println("Choose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("Type 'quit' to exit.");

            // Get user input for the operation
            userChoice = scanner.nextLine().trim().toLowerCase();

            // Exit if user selects "quit"
            if (userChoice.equals("quit")) {
                System.out.println("Exiting program.");
                break;
            }

            // Validate the user choice for operation
            if (!userChoice.matches("[1-4+\\-*/]")) {
                System.out.println("Invalid option. Please try again.");
                continue;  // Skip to the next loop iteration to ask for a valid option
            }

            // Get and validate the first number
            num1 = getValidNumber(scanner, "Enter the first number: ");
            // Get and validate the second number
            num2 = getValidNumber(scanner, "Enter the second number: ");

            // Perform the operation based on user input
            switch (userChoice) {
                case "1":
                case "+":
                    result = num1 + num2;
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                    break;

                case "2":
                case "-":
                    result = num1 - num2;
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                    break;

                case "3":
                case "*":
                    result = num1 * num2;
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                    break;

                case "4":
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        result = num1 / num2;
                        System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to get a valid number from the user
    private static double getValidNumber(Scanner scanner, String prompt) {
        double num;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                scanner.nextLine();  // Consume the newline character
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();  // Consume the invalid input
            }
        }
        return num;
    }
}
