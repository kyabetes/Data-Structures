import java.util.ArrayList;
import java.util.Scanner;

public class DinnerParty extends Party {
    private int dinnerChoice;
    private ArrayList<Integer> ratings;

    public DinnerParty() {
        super();
        ratings = new ArrayList<>();
    }

    public void setDinnerChoice(int choice) {
        dinnerChoice = choice;
    }

    public int getDinnerChoice() {
        return dinnerChoice;
    }

    public void collectRatings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Collecting ratings from guests (Enter -1 to end):");
        while (true) {
            int rating = scanner.nextInt();
            if (rating == -1) {
                break;
            }
            ratings.add(rating);
        }
    }

    public double calculateAverageRating() {
        if (ratings.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return (double) sum / ratings.size();
    }
}
