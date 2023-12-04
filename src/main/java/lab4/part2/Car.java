package lab4.part2;// Car.java
import javax.swing.JOptionPane;


//  This class is a subclass of Publication and inherits all of its methods and the purpose
//  of this class is to represent a car object. It has a title, price, and number of copies.
//  It also has an edit and initialize method that allows the user to edit and initialize the
//  attributes of the car object.
public class Car extends Publication {

    public Car(String title, double price, int copies) {
        super(title, price, copies);
    }

    @Override
    public void edit() {
        String newTitle = JOptionPane.showInputDialog("Enter new title:", getTitle());
        if (newTitle != null) {
            setTitle(newTitle);
        }

        String priceStr = JOptionPane.showInputDialog("Enter new price:", getPrice());
        if (priceStr != null) {
            try {
                double newPrice = Double.parseDouble(priceStr);
                setPrice(newPrice);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid price. Please enter a valid number.");
            }
        }

        String copiesStr = JOptionPane.showInputDialog("Enter new number of copies:", getCopies());
        if (copiesStr != null) {
            try {
                int newCopies = Integer.parseInt(copiesStr);
                setCopies(newCopies);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number of copies. Please enter a valid integer.");
            }
        }
    }

    @Override
    public void initialize() {
        String title = JOptionPane.showInputDialog("Enter title:");
        if (title != null) {
            setTitle(title);
        }

        String priceStr = JOptionPane.showInputDialog("Enter price:");
        if (priceStr != null) {
            try {
                double price = Double.parseDouble(priceStr);
                setPrice(price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid price. Please enter a valid number.");
            }
        }

        String copiesStr = JOptionPane.showInputDialog("Enter number of copies:");
        if (copiesStr != null) {
            try {
                int copies = Integer.parseInt(copiesStr);
                setCopies(copies);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number of copies. Please enter a valid integer.");
            }
        }
    }
}
