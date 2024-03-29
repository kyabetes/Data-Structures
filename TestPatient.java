import java.util.Scanner;

public class TestPatient {
    public static void main(String[] args) {
        // create scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // create patient object with default values
        Patient defaultPatient = new Patient();

        // create patient object with user input values
        System.out.println("enter details for patient 1:");
        Patient userPatient = createPatientWithUserInput(scanner);

        // create patient object with user input values for patient data and default blood data
        System.out.println("\nenter details for patient 2:");
        Patient mixedPatient = createPatientWithUserInputAndDefaultBloodData(scanner);

        // display details of all patient objects
        System.out.println("\ndefault patient:");
        displayPatientDetails(defaultPatient);

        System.out.println("\nuser input patient:");
        displayPatientDetails(userPatient);

        System.out.println("\nMixed patient:");
        displayPatientDetails(mixedPatient);
    }

    // helper method to create patient object with user input values
    private static Patient createPatientWithUserInput(Scanner scanner) {
        System.out.print("enter ID number: ");
        int idNumber = scanner.nextInt();
        System.out.print("enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("enter blood type: ");
        String bloodType = scanner.nextLine().toUpperCase();
        System.out.print("enter Rh factor (+ or -): ");
        String rhFactor = scanner.nextLine();

        BloodData bloodData = new BloodData(BloodData.BloodGroup.valueOf(bloodType), rhFactor);
        return new Patient(idNumber, age, bloodData);
    }

    // helper method to create patient object with user input values for patient data and default blood data
    private static Patient createPatientWithUserInputAndDefaultBloodData(Scanner scanner) {
        System.out.print("enter ID number: ");
        int idNumber = scanner.nextInt();
        System.out.print("enter age: ");
        int age = scanner.nextInt();

        return new Patient(idNumber, age, new BloodData());
    }

    // helper method to display patient details
    private static void displayPatientDetails(Patient patient) {
        System.out.println("ID number: " + patient.getIdNumber());
        System.out.println("age: " + patient.getAge());
        System.out.println("blood Type: " + patient.getBloodData().getBloodType());
        System.out.println("Rh factor: " + patient.getBloodData().getRhFactor());
    }
}