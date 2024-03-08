class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        int bulkQuantities = quantity / item.getBulkQuantity();
        int remainingQuantity = quantity % item.getBulkQuantity();
        double bulkPrice = bulkQuantities * item.getBulkPrice();
        double regularPrice = remainingQuantity * item.getPrice();
        return bulkPrice + regularPrice;
    }
}