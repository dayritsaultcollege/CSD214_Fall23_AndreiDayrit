package lab3.q3;

public abstract class Publication {
    private String title;
    private double price;
    private int quantityInStock;

    public Publication(String title, double price, int quantityInStock) {
        this.title = title;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Publication other = (Publication) obj;
        return Double.compare(other.price, price) == 0 &&
                quantityInStock == other.quantityInStock &&
                title.equals(other.title);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        long temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantityInStock;
        return result;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Price: $" + price + ", Quantity in Stock: " + quantityInStock;
    }
}
