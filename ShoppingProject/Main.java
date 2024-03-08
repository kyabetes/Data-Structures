public class Main {
    public static void main(String[] args) {
        // Create some items
        Item tissues = new Item("Tissues", 3.0, 4.0, 2);
        Item milk = new Item("Milk", 2.5);

        // Create some item orders
        ItemOrder tissueOrder = new ItemOrder(tissues, 5); // 2 boxes at $4 each, 1 box at $3
        ItemOrder milkOrder = new ItemOrder(milk, 2);

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add orders to the cart
        cart.addOrder(tissueOrder);
        cart.addOrder(milkOrder);

        // Check if an order is in the cart
        System.out.println(cart.containsOrder(tissueOrder)); // true

        // Remove an order from the cart
        cart.removeOrder(milkOrder);

        // Get the total price of the cart
        System.out.println("Total price: $" + cart.getTotalPrice()); // Total price: $11.0
    }
}
