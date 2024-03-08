import java.util.ArrayList;

class ShoppingCart {
    private ArrayList<ItemOrder> orders;

    public ShoppingCart() {
        orders = new ArrayList<>();
    }

    public void addOrder(ItemOrder order) {
        orders.add(order);
    }

    public void removeOrder(ItemOrder order) {
        orders.remove(order);
    }

    public boolean containsOrder(ItemOrder order) {
        return orders.contains(order);
    }

    public double getTotalPrice() {
        double total = 0;
        for (ItemOrder order : orders) {
            total += order.getTotalPrice();
        }
        return total;
    }
}
