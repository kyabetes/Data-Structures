import javax.swing.*;
import java.time.LocalDate;

public class TestWedding {
    public static void main(String[] args) {
        // create text fields for input
        JTextField brideFirstNameField = new JTextField(10);
        JTextField brideLastNameField = new JTextField(10);
        JTextField groomFirstNameField = new JTextField(10);
        JTextField groomLastNameField = new JTextField(10);
        JTextField weddingDateField = new JTextField(10);
        JTextField locationField = new JTextField(10);

        // prepare the panel with form labels and fields
        JPanel panel = new JPanel();
        panel.add(new JLabel("Bride's First Name:"));
        panel.add(brideFirstNameField);
        panel.add(new JLabel("Bride's Last Name:"));
        panel.add(brideLastNameField);
        panel.add(new JLabel("Groom's First Name:"));
        panel.add(groomFirstNameField);
        panel.add(new JLabel("Groom's Last Name:"));
        panel.add(groomLastNameField);
        panel.add(new JLabel("Wedding Date (YYYY-MM-DD):"));
        panel.add(weddingDateField);
        panel.add(new JLabel("Location:"));
        panel.add(locationField);

        // show dialog with form and OK/Cancel buttons
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Wedding Details",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // collect input data
            String brideFirstName = brideFirstNameField.getText();
            String brideLastName = brideLastNameField.getText();
            String groomFirstName = groomFirstNameField.getText();
            String groomLastName = groomLastNameField.getText();
            LocalDate weddingDate = LocalDate.parse(weddingDateField.getText());
            String location = locationField.getText();

            // create wedding objects
            Person bride = new Person(brideFirstName, brideLastName);
            Person groom = new Person(groomFirstName, groomLastName);
            Couple couple = new Couple(bride, groom);
            Wedding wedding = new Wedding(couple, weddingDate, location);

            // display wedding details
            String message = "Wedding Details:\nBride: " + bride.getFirstName() + " " + bride.getLastName() +
                    "\nGroom: " + groom.getFirstName() + " " + groom.getLastName() +
                    "\nDate: " + wedding.getWeddingDate() +
                    "\nLocation: " + wedding.getLocation();
            JOptionPane.showMessageDialog(null, message);
        } else {
            System.exit(0);
        }
    }
}
