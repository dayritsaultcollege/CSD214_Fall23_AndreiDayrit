package lab4.part1;

public class Magazine extends Publication {
    private String issue;

    public Magazine(String title, double price, int quantityInStock, String issue) {
        super(title, price, quantityInStock);
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return super.toString() + ", Issue: " + issue;
    }
}
