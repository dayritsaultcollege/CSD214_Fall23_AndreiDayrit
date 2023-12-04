package lab4.part2;

//  This is an abstract class. It cannot be instantiated and it purpose is to be
//  extended by other classes and work as a template.
public abstract class Publication {
    private String title;
    private double price;
    private int copies;
    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public abstract void edit();

    public abstract void initialize();

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

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
