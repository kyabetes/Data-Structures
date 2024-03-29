import java.util.Scanner;

public class TestBloodData {
    public static void main(String[] args) {
        // create scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // declare two BloodData objects
        BloodData defaultBloodData = new BloodData();
        BloodData userBloodData = null;

        // prompt user for blood type
        System.out.print("enter blood type:");
        String bloodTypeInput = scanner.nextLine().toUpperCase();

        // prompt user for rh factor
        System.out.print("enter Rh factor (+ or -): ");
        String rhFactorInput = scanner.nextLine();

        try {
            // create BloodData object with user input
            BloodData.BloodGroup bloodType = BloodData.BloodGroup.valueOf(bloodTypeInput);
            userBloodData = new BloodData(bloodType, rhFactorInput);
        } catch (IllegalArgumentException e) {
            System.out.println("invalid input. using default values.");
            userBloodData = new BloodData();
        }

        // display details of both objects
        System.out.println("\ndefault blood data:");
        displayBloodData(defaultBloodData);

        System.out.println("\nuser blood data:");
        displayBloodData(userBloodData);

        // change default object to use user's values
        defaultBloodData.setBloodType(userBloodData.getBloodType());
        defaultBloodData.setRhFactor(userBloodData.getRhFactor());

        // display details of default object after changes
        System.out.println("\nafter changes:");
        displayBloodData(defaultBloodData);
    }

    // helper method to display blood data details
    private static void displayBloodData(BloodData bloodData) {
        System.out.println("blood Type: " + bloodData.getBloodType());
        System.out.println("rh Factor: " + bloodData.getRhFactor());
    }
}
