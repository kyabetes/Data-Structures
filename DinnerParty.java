public class DinnerParty extends Party {
    private int dinnerChoice; // Additional data field for DinnerParty

    // Method to set the dinner menu choice
    public void setDinnerChoice(int choice) {
        dinnerChoice = choice;
    }

    // Method to get the dinner menu choice
    public int getDinnerChoice() {
        return dinnerChoice;
    }
}
