package lab3.q3;

public class Book extends Publication {
    private String author;

    public Book(String title, double price, int quantityInStock, String author) {
        super(title, price, quantityInStock);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}
