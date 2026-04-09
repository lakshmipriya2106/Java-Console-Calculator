import java.util.Scanner;

/**
 * Java Console Calculator
 * Supports: addition, subtraction, multiplication, division
 * Runs in a loop until the user chooses to exit.
 */
public class Calculator {

    // ─────────────────────────────────────────────
    //  Arithmetic Methods
    // ─────────────────────────────────────────────

    /** Returns the sum of two numbers. */
    static double add(double a, double b) {
        return a + b;
    }

    /** Returns the difference of two numbers. */
    static double subtract(double a, double b) {
        return a - b;
    }

    /** Returns the product of two numbers. */
    static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Returns the quotient of two numbers.
     * Throws ArithmeticException if the divisor is zero.
     */
    static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }

    // ─────────────────────────────────────────────
    //  Helper: print the menu
    // ─────────────────────────────────────────────
    static void printMenu() {
        System.out.println();
        System.out.println("╔══════════════════════════╗");
        System.out.println("║     JAVA CALCULATOR      ║");
        System.out.println("╠══════════════════════════╣");
        System.out.println("║  1. Addition      ( + )  ║");
        System.out.println("║  2. Subtraction   ( - )  ║");
        System.out.println("║  3. Multiplication( × )  ║");
        System.out.println("║  4. Division      ( ÷ )  ║");
        System.out.println("║  5. Exit                 ║");
        System.out.println("╚══════════════════════════╝");
        System.out.print("Choose an option (1-5): ");
    }

    // ─────────────────────────────────────────────
    //  Helper: safely read a double from the user
    // ─────────────────────────────────────────────
    static double readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                return value;
            } else {
                System.out.println("  ⚠  Invalid input. Please enter a number.");
                scanner.next(); // discard bad token
            }
        }
    }

    // ─────────────────────────────────────────────
    //  Main – program entry point
    // ─────────────────────────────────────────────
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Java Console Calculator!");

        while (running) {

            printMenu();

            // Read the menu choice
            int choice = 0;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("  ⚠  Please enter a number between 1 and 5.");
                scanner.next(); // discard bad token
                continue;
            }

            // Exit early if user picks 5
            if (choice == 5) {
                running = false;
                System.out.println("\nThank you for using the calculator. Goodbye! 👋");
                break;
            }

            // Validate menu choice
            if (choice < 1 || choice > 4) {
                System.out.println("  ⚠  Invalid choice. Please select 1–5.");
                continue;
            }

            // Read two operands
            double numA = readNumber(scanner, "Enter first number : ");
            double numB = readNumber(scanner, "Enter second number: ");

            // Perform the selected operation
            double result = 0;
            String operation = "";

            try {
                switch (choice) {
                    case 1:
                        result    = add(numA, numB);
                        operation = numA + " + " + numB;
                        break;
                    case 2:
                        result    = subtract(numA, numB);
                        operation = numA + " - " + numB;
                        break;
                    case 3:
                        result    = multiply(numA, numB);
                        operation = numA + " × " + numB;
                        break;
                    case 4:
                        result    = divide(numA, numB);
                        operation = numA + " ÷ " + numB;
                        break;
                }

                // Display result
                System.out.println("\n  ✔  " + operation + " = " + result);

            } catch (ArithmeticException e) {
                System.out.println("\n  ✖  Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}