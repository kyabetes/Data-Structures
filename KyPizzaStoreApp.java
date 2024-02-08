import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KyPizzaStoreApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ky Pizza Store");
            frame.setSize(500, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            String[] sizes = {"Small", "Medium", "Large", "Super"};
            JComboBox<String> sizeDropdown = new JComboBox<>(sizes);
            frame.add(sizeDropdown);

            JCheckBox topping1 = new JCheckBox("Topping 1");
            JCheckBox topping2 = new JCheckBox("Topping 2");
            JCheckBox topping3 = new JCheckBox("Topping 3");
            frame.add(topping1);
            frame.add(topping2);
            frame.add(topping3);

            JButton calculateButton = new JButton("Calculate Price and Nutritional Info");
            JLabel priceLabel = new JLabel("Price: $0");
            JLabel caloriesLabel = new JLabel("Calories: 0 kcal");
            JLabel fatsLabel = new JLabel("Fats: 0 g");
            JLabel proteinsLabel = new JLabel("Proteins: 0 g");

            frame.add(calculateButton);
            frame.add(priceLabel);
            frame.add(caloriesLabel);
            frame.add(fatsLabel);
            frame.add(proteinsLabel);

            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int basePrice = switch (sizeDropdown.getSelectedIndex()) {
                        case 0 -> 5;
                        case 1 -> 10;
                        case 2 -> 15;
                        default -> 20;
                    };

                    int toppingCount = 0;
                    if (topping1.isSelected()) toppingCount++;
                    if (topping2.isSelected()) toppingCount++;
                    if (topping3.isSelected()) toppingCount++;

                    double toppingsPrice = switch (toppingCount) {
                        case 1, 2 -> toppingCount * 0.50;
                        case 3 -> 1.25;
                        default -> 0;
                    };

                    double totalPrice = basePrice + toppingsPrice;

                    // nutritional information (fictional values)
                    int[] baseCalories = {250, 500, 750, 1000}; // calories for each size
                    int[] baseFats = {10, 20, 30, 40}; // fats for each size
                    int[] baseProteins = {15, 30, 45, 60}; // proteins for each size
                    int calories = baseCalories[sizeDropdown.getSelectedIndex()];
                    int fats = baseFats[sizeDropdown.getSelectedIndex()];
                    int proteins = baseProteins[sizeDropdown.getSelectedIndex()];

                    // additional nutritional information per topping
                    int toppingCalories = 50; // additional calories per topping
                    int toppingFats = 2; // additional fats per topping
                    int toppingProteins = 5; // additional proteins per topping

                    calories += toppingCount * toppingCalories;
                    fats += toppingCount * toppingFats;
                    proteins += toppingCount * toppingProteins;

                    priceLabel.setText(String.format("Price: $%.2f", totalPrice));
                    caloriesLabel.setText(String.format("Calories: %d kcal", calories));
                    fatsLabel.setText(String.format("Fats: %d g", fats));
                    proteinsLabel.setText(String.format("Proteins: %d g", proteins));
                }
            });

            frame.setVisible(true);
        });
    }
}
