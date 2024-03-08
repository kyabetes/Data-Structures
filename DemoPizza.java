import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DemoPizza extends JFrame {
    private static final String QUIT = "QUIT";
    private JTextField toppingField;
    private JTextArea outputArea;
    private ArrayList<String> toppings;

    public DemoPizza() {
        setTitle("Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel toppingLabel = new JLabel("Enter topping (or QUIT to finish):");
        toppingField = new JTextField(20);
        JButton addButton = new JButton("Add Topping");
        addButton.addActionListener(new AddToppingListener());
        inputPanel.add(toppingLabel);
        inputPanel.add(toppingField);
        inputPanel.add(addButton);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        toppings = new ArrayList<>();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class AddToppingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String topping = toppingField.getText().trim();
            if (topping.equalsIgnoreCase(QUIT)) {
                createPizza();
            } else if (!topping.isEmpty() && toppings.size() < 10) {
                toppings.add(topping);
                toppingField.setText("");
            } else if (toppings.size() >= 10) {
                JOptionPane.showMessageDialog(DemoPizza.this, "Maximum number of toppings reached.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void createPizza() {
        int numToppings = toppings.size();
        String[] toppingArray = toppings.toArray(new String[numToppings]);

        boolean isDelivery = JOptionPane.showConfirmDialog(this, "Is this pizza for delivery?", "Delivery?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        if (isDelivery) {
            String deliveryAddress = JOptionPane.showInputDialog(this, "Enter delivery address:");
            if (deliveryAddress != null && !deliveryAddress.isEmpty()) {
                DeliveryPizza pizza = new DeliveryPizza(toppingArray, numToppings, deliveryAddress);
                outputArea.setText(pizza.toString());
            }
        } else {
            Pizza pizza = new Pizza(toppingArray, numToppings);
            outputArea.setText(pizza.toString());
        }

        toppings.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DemoPizza::new);
    }
}