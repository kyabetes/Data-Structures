class Item {
    private String name;
    private double price;
    private double bulkPrice;
    private int bulkQuantity;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.bulkPrice = 0;
        this.bulkQuantity = 0;
    }

    public Item(String name, double price, double bulkPrice, int bulkQuantity) {
        this.name = name;
        this.price = price;
        this.bulkPrice = bulkPrice;
        this.bulkQuantity = bulkQuantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getBulkPrice() {
        return bulkPrice;
    }

    public int getBulkQuantity() {
        return bulkQuantity;
    }
}
