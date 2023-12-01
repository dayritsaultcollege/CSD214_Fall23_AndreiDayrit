package lab4;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PublicationApp {
    private static final ArrayList<Book> books = new ArrayList<>();
    private static final ArrayList<Magazine> magazines = new ArrayList<>();
    private static final ArrayList<DiscMagazine> discMagazines = new ArrayList<>();
    private static final ArrayList<Object> otherItems = new ArrayList<>();  // ArrayList to store CashTill, Ticket, Pencil
    private static final Scanner scanner = new Scanner(System.in);




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Publication App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel panel = new JPanel();
            frame.getContentPane().add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        });

        int choice;
        do {
            System.out.println("---------------Publication Menu-----------------");
            System.out.println("1. List all Books");
            System.out.println("2. Add a Book");
            System.out.println("3. Edit a Book");
            System.out.println("4. Delete a Book");
            System.out.println("5. Add Magazine");
            System.out.println("6. List Magazine");
            System.out.println("7. Add Disc Magazine");
            System.out.println("8. List Disc Magazine");
            System.out.println("9. Add Cash Till");
            System.out.println("10. Add Ticket");
            System.out.println("11. Add Pencil");
            System.out.println("12. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    addMagazine();
                    break;
                case 6:
                    listMagazines();
                    break;
                case 7:
                    addDiscMagazine();
                    break;
                case 8:
                    listDiscMagazines();
                    break;
                case 9:
                    addCashTill();
                    break;
                case 10:
                    addTicket();
                    break;
                case 11:
                    addPencil();
                    break;
                case 12:
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 12);
    }

    //All the methods below are static methods that are called from the main method.


    //This method lists all the books in the publications ArrayList.
// This method lists all the books in the publications ArrayList.
    public static void listAllBooks() {
        System.out.println("---------------List of Books-----------------");
        int index = 1;
        for (Object item : books) {
            if (item instanceof Book) {
                System.out.println(index + ". " + item);
                index++;
            }
        }
        System.out.println("---------------------------------------------");

        // Additional code to list CashTill, Ticket, Pencil
        System.out.println("---------------Other Items-----------------");
        for (Object item : otherItems) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------");
    }


    // This method adds a book to the books ArrayList.
// This method adds a book to the books ArrayList.
    public static void addBook() {
        System.out.println("---------------Add a Book----------------------");
        System.out.print("Enter Author ('q' to quit): ");
        String author = scanner.nextLine();
        if ("q".equalsIgnoreCase(author)) {
            return;
        }

        System.out.print("Quantity to Order: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character

        try {
            Book book = new Book(title, price, quantity, author);
            for (Object item : books) {
                if (item instanceof Book && item.equals(book)) {
                    Book existingBook = (Book) item;
                    existingBook.setQuantityInStock(existingBook.getQuantityInStock() + quantity);
                    System.out.println("Book added successfully.");
                    return;
                }
            }
            System.out.println("Book added successfully.");
        } catch (ClassCastException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }



    // This method edits a book in the books ArrayList.
    public static void editBook() {
        System.out.println("---------------Edit a Book----------------------");
        System.out.print("Enter the title of the book to edit: ");
        String titleToEdit = scanner.nextLine();

        for (int i = 0; i < books.size(); i++) {
            Book publication = books.get(i);
            if (publication instanceof Book && publication.getTitle().equalsIgnoreCase(titleToEdit)) {
                Book book = (Book) publication;
                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();

                book.setAuthor(newAuthor);
                book.setPrice(newPrice);
                book.setQuantityInStock(newQuantity);

                System.out.println("Book edited successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void deleteBook() {
        System.out.println("---------------Delete a Book----------------------");
        System.out.print("Enter the title of the book to delete: ");
        String titleToDelete = scanner.nextLine();

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(titleToDelete)) {
                books.remove(i);  // Remove by index
                System.out.println("Book deleted successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }



    //This method adds a magazine to the publications ArrayList.
    public static void addMagazine() {
        System.out.println("---------------Add a Magazine----------------------");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter issue: ");
        String issue = scanner.nextLine();

        Magazine magazine = new Magazine(title, price, quantity, issue);
        magazines.add(magazine);
        System.out.println("Magazine added successfully.");
    }


    //This method lists all the magazines in the publications ArrayList.
    public static void listMagazines() {
        System.out.println("---------------List of Magazines-----------------");
        int index = 1;
        for (Magazine publication : magazines) {
            System.out.println(index + ". " + publication);
            index++;
        }
        System.out.println("---------------------------------------------");
    }


    //This method adds a disc magazine to the publications ArrayList.
    public static void addDiscMagazine() {
        System.out.println("---------------Add a Disc Magazine----------------------");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter number of discs: ");
        int numberOfDiscs = scanner.nextInt();

        DiscMagazine discMagazine = new DiscMagazine(title, price, quantity, numberOfDiscs);
        discMagazines.add(discMagazine);
        System.out.println("Disc Magazine added successfully.");
    }


    //This method lists all the disc magazines in the publications ArrayList.
    public static void listDiscMagazines() {
        System.out.println("---------------List of Disc Magazines-----------------");
        int index = 1;
        for (DiscMagazine publication : discMagazines) {
            System.out.println(index + ". " + publication);
            index++;
        }
        System.out.println("---------------------------------------------");
    }

    public static void addCashTill() {
        System.out.println("---------------Add a Cash Till----------------------");
        CashTill cashTill = new CashTill();
        otherItems.add(cashTill);
        System.out.println("Cash Till added successfully.");
    }

    public static void addTicket() {
        System.out.println("---------------Add a Ticket----------------------");
        System.out.print("Enter ticket number: ");
        String ticketNumber = scanner.nextLine();
        Ticket ticket = new Ticket(ticketNumber);
        otherItems.add(ticket);
        System.out.println("Ticket added successfully.");
    }

    public static void addPencil() {
        System.out.println("---------------Add a Pencil----------------------");
        System.out.print("Enter pencil color: ");
        String color = scanner.nextLine();
        Pencil pencil = new Pencil(color);
        otherItems.add(pencil);
        System.out.println("Pencil added successfully.");
    }

    // GUI components for Swing
    private static void placeComponents(JPanel panel) {
        // Add Swing GUI components here...
    }
}
