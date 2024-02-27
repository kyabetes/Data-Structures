import java.util.Scanner;

public class SquareRootApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its square root: ");
        try {
            double number = scanner.nextDouble();
            if (number < 0) {
                throw new ArithmeticException("Cannot take the square root of a negative number.");
            }
            double result = Math.sqrt(number);
            System.out.println("The square root of " + number + " is " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
