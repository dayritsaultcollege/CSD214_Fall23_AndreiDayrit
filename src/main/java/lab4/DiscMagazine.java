package lab4;

import lab4.Publication;

public class DiscMagazine extends Publication {
    private int numberOfDiscs;

    public DiscMagazine(String title, double price, int quantityInStock, int numberOfDiscs) {
        super(title, price, quantityInStock);
        this.numberOfDiscs = numberOfDiscs;
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public void setNumberOfDiscs(int numberOfDiscs) {
        this.numberOfDiscs = numberOfDiscs;
    }

    @Override
    public String toString() {
        return super.toString() + ", Number of Discs: " + numberOfDiscs;
    }
}
