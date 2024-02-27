import java.util.Scanner;

public class UseDinnerParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DinnerParty dinnerParty = new DinnerParty();

        // For the regular party
        System.out.print("Enter number of guests for the party >> ");
        int guests = scanner.nextInt();
        dinnerParty.setGuests(guests);
        System.out.println("The party has " + dinnerParty.getGuests() + " guests");
        dinnerParty.displayInvitation();

        // For the dinner party
        System.out.print("Enter number of guests for the dinner party >> ");
        int guests2 = scanner.nextInt();
        dinnerParty.setGuests(guests2);

        System.out.print("Enter the menu option -- 1 for chicken or 2 for Vegi >> ");
        int choice = scanner.nextInt();
        dinnerParty.setDinnerChoice(choice);

        System.out.println("The dinner party has " + dinnerParty.getGuests() + " guests");
        System.out.println("Menu option " + dinnerParty.getDinnerChoice() + " will be served");
        dinnerParty.displayInvitation();

        // New feature: Collect ratings and display average
        dinnerParty.collectRatings();
        double averageRating = dinnerParty.calculateAverageRating();
        System.out.println("Average rating for the dinner party: " + averageRating);
    }
}
