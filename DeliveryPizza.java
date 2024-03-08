public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String[] toppings, int numToppings, String deliveryAddress) {
        super(toppings, numToppings);
        this.deliveryAddress = deliveryAddress;
        if (super.price > 18.0) {
            this.deliveryFee = 3.0;
        } else {
            this.deliveryFee = 5.0;
        }
        System.out.println("Delivery Address: " + this.deliveryAddress);
        System.out.println("Delivery Fee: $" + this.deliveryFee);
    }

    @Override
    public String toString() {
        return super.toString() + "\nDelivery Address: " + deliveryAddress + "\nDelivery Fee: $" + deliveryFee;
    }
}