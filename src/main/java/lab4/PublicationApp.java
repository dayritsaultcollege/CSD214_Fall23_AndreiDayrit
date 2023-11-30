package lab4;

import lab3.q3.Book;
import lab3.q3.DiscMagazine;
import lab3.q3.Magazine;
import lab3.q3.Publication;

import java.util.ArrayList;
import java.util.Scanner;

public class PublicationApp {
    private static final ArrayList<Publication> publications = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
            System.out.println("9. Quit");
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
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);
    }

    //All the methods below are static methods that are called from the main method.


    //This method lists all the books in the publications ArrayList.
    public static void listAllBooks() {
        System.out.println("---------------List of Books-----------------");
        int index = 1;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                System.out.println(index + ". " + publication);
                index++;
            }
        }
        System.out.println("---------------------------------------------");
    }

    //This method adds a book to the publications ArrayList.
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

        Book book = new Book(title, price, quantity, author);

        publications.add(book);
        System.out.println("Book added successfully.");
    }


    //This method edits a book in the publications ArrayList.
    public static void editBook() {
        System.out.println("---------------Edit a Book----------------------");
        System.out.print("Enter the title of the book to edit: ");
        String titleToEdit = scanner.nextLine();

        for (Publication publication : publications) {
            if (publication instanceof Book book && publication.getTitle().equalsIgnoreCase(titleToEdit)) {
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


    //This method deletes a book from the publications ArrayList.
    public static void deleteBook() {
        System.out.println("---------------Delete a Book----------------------");
        System.out.print("Enter the title of the book to delete: ");
        String titleToDelete = scanner.nextLine();

        for (Publication publication : publications) {
            if (publication instanceof Book && publication.getTitle().equalsIgnoreCase(titleToDelete)) {
                publications.remove(publication);
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
        publications.add(magazine);
        System.out.println("Magazine added successfully.");
    }


    //This method lists all the magazines in the publications ArrayList.
    public static void listMagazines() {
        System.out.println("---------------List of Magazines-----------------");
        int index = 1;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                System.out.println(index + ". " + publication);
                index++;
            }
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
        publications.add(discMagazine);
        System.out.println("Disc Magazine added successfully.");
    }


    //This method lists all the disc magazines in the publications ArrayList.
    public static void listDiscMagazines() {
        System.out.println("---------------List of Disc Magazines-----------------");
        int index = 1;
        for (Publication publication : publications) {
            if (publication instanceof DiscMagazine) {
                System.out.println(index + ". " + publication);
                index++;
            }
        }
        System.out.println("---------------------------------------------");
    }
}