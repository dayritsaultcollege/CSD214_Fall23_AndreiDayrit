package lab4.part1;

public class CashTill {
    private double cashBalance;

    public CashTill() {
        this.cashBalance = 0;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void addCash(double amount) {
        cashBalance += amount;
    }

    public void subtractCash(double amount) {
        cashBalance -= amount;
    }
}
