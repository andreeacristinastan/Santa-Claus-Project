package receivegifts;

public final class ReceivedGift {
    private String productName;
    private double price;
    private String category;

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public ReceivedGift(final String productName,
                        final double price,
                        final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
}
