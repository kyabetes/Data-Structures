public class Pizza {
    public String[] toppings;
    public double price;

    public Pizza(String[] toppings, int numToppings) {
        this.toppings = new String[10];
        System.arraycopy(toppings, 0, this.toppings, 0, numToppings);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numToppings; i++) {
            sb.append(this.toppings[i]);
            if (i < numToppings - 1) {
                sb.append(", ");
            }
        }
        this.price = 14.0 + (2.0 * numToppings);
        System.out.println("Pizza description: " + sb.toString());
        System.out.println("Price: $" + this.price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < toppings.length && toppings[i] != null; i++) {
            sb.append(toppings[i]);
            if (i < toppings.length - 1 && toppings[i + 1] != null) {
                sb.append(", ");
            }
        }
        return "Pizza description: " + sb.toString() + "\nPrice: $" + price;
    }
}