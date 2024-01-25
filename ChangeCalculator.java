import java.util.Scanner;

public class ChangeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount in dollars (e.g., 4.55): ");
        double amount = scanner.nextDouble();

        System.out.println("Do you want quarters? (yes/no): ");
        boolean useQuarters = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Do you want dimes? (yes/no): ");
        boolean useDimes = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Do you want nickels? (yes/no): ");
        boolean useNickels = scanner.next().equalsIgnoreCase("yes");

        int totalCents = (int) (amount * 100);
        int quarters = 0, dimes = 0, nickels = 0;

        if (useQuarters) {
            quarters = totalCents / 25;
            totalCents %= 25;
        }

        if (useDimes) {
            dimes = totalCents / 10;
            totalCents %= 10;
        }

        if (useNickels) {
            nickels = totalCents / 5;
            totalCents %= 5;
        }

        int pennies = totalCents; // remaining cents as pennies

        System.out.println("Quarters: " + quarters + " ($" + (quarters * 0.25) + ")");
        System.out.println("Dimes: " + dimes + " ($" + (dimes * 0.10) + ")");
        System.out.println("Nickels: " + nickels + " ($" + (nickels * 0.05) + ")");
        System.out.println("Pennies: " + pennies + " ($" + (pennies * 0.01) + ")");
    }
}
