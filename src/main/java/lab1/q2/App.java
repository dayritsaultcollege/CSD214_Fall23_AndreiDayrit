package lab1.q2;

/**
 Author : Andrei Dayrit
 Date : 10/1/2023
 Description : This application allows the user to add, edit, delete, list, and sell cars
                and stores the cars in an array of Car objects. With the use of the Person class and the Car class.
 **/

import lab1.q1.Person;

import java.util.Scanner;

public class App {

    private final int numCars = 100;
    private Car[] unsoldCars = new Car[numCars];
    private Car[] soldCars = new Car[numCars];
    private int unsoldCurrentIndex = 0;
    private int soldCurrentIndex = 0;
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    // This method runs the application with a menu for the user to interact with
    public void run() {
        String menu = ""
                + "----------------------\n"
                + " 1. Add a Car\n"
                + " 2. Edit a Car\n"
                + " 3. Delete an unsold Car\n"
                + " 4. Delete a sold Car\n"
                + " 5. List unsold Cars\n"
                + " 6. List sold Cars\n"
                + " 7. Sell a Car\n"
                + "99. Exit\n"
                + "----------------------\n";

        int decision;
        // Do-while loop to keep the application running until the user decides to exit
        do {
            System.out.println(menu);
            //input for the user to decide what to do
            System.out.print("Enter your decision: ");
            decision = input.nextInt();
            input.nextLine();

            switch (decision) {
                case 1:
                    // Add a Car to the unsoldCars array
                    // Get input for car details from the user

                    System.out.print("Enter car make: ");
                    String make = input.nextLine();

                    System.out.print("Enter car model: ");
                    String model = input.nextLine();

                    System.out.print("Enter car year: ");
                    int year = input.nextInt();

                    System.out.print("Enter car VIN: ");
                    int vin = input.nextInt();

                    // Create a new Car object with the input details and VIN number from the user
                    Car newCar = new Car(make, model, year, vin);

                    // Add the new Car object to the unsoldCars array and increment the current index by 1
                    unsoldCars[unsoldCurrentIndex] = newCar;
                    unsoldCurrentIndex++;

                    System.out.println("A new Car has added successfully.");
                    break;

                case 2:
                    // Edit a Car in the unsoldCars array

                    // Prompt the user for which car to edit
                    System.out.print("Enter the index of the car to edit: ");
                    int editIndex = input.nextInt();

                    //checking if the index is valid, using a if statement
                    if (editIndex >= 0 && editIndex < unsoldCurrentIndex) {

                        Car carToEdit = unsoldCars[editIndex];

                        //prompt the user for the new car details
                        System.out.print("Enter new car make: ");
                        String newMake = input.nextLine();

                        // Update other car details similarly as above
                        carToEdit.setMake(newMake);


                        System.out.println("Car edited successfully.");
                    } else {
                        System.out.println("Invalid car index. Please try again.");
                    }
                    break;

                case 3:
                    // Delete an unsold Car from the unsoldCars array

                    // Prompt the user for which car to delete
                    System.out.print("Enter the index of the unsold car to delete: ");
                    int deleteIndex = input.nextInt();

                    // Using the if statement to check if the index is valid
                    if (deleteIndex >= 0 && deleteIndex < unsoldCurrentIndex) {
                        // Shift the cars to the left to fill the gap
                        for (int i = deleteIndex; i < unsoldCurrentIndex - 1; i++) {
                            unsoldCars[i] = unsoldCars[i + 1];
                        }

                        // Set the last element to null to remove the reference
                        unsoldCars[unsoldCurrentIndex - 1] = null;

                        // Decrement the current index by 1
                        unsoldCurrentIndex--;

                        System.out.println("Car deleted successfully.");
                    } else {
                        System.out.println("Invalid car index. Please try again.");
                    }
                    break;


                case 4:
                    // Delete a sold Car from the soldCars array

                    System.out.print("Enter the index of the sold car to delete: ");
                    int deleteSoldIndex = input.nextInt();


                    if (deleteSoldIndex >= 0 && deleteSoldIndex < soldCurrentIndex) {

                        for (int i = deleteSoldIndex; i < soldCurrentIndex - 1; i++) {
                            soldCars[i] = soldCars[i + 1];
                        }


                        // Set the last element to null
                        soldCars[soldCurrentIndex - 1] = null;

                        // Decrement the current index by 1
                        soldCurrentIndex--;

                        System.out.println("Sold car deleted successfully.");
                    } else {
                        System.out.println("Invalid sold car index. Please try again.");
                    }
                    break;

                case 5:
                    // List unsold Cars stored in the unsoldCars array
                    System.out.println("Unsold Cars:");
                    for (int i = 0; i < unsoldCurrentIndex; i++) {
                        System.out.println(i + ": " + unsoldCars[i]);
                    }
                    break;

                case 6:
                    // List sold Cars stored in the soldCars array
                    System.out.println("Sold Cars:");
                    for (int i = 0; i < soldCurrentIndex; i++) {
                        System.out.println(i + ": " + soldCars[i]);
                    }
                    break;

                case 7:
                    // Sell a Car from the unsoldCars array and add it to the soldCars array

                    // Prompt the user for which car to sell from the unsoldCars array
                    System.out.print("Enter the index of the car to sell: ");
                    int sellIndex = input.nextInt();

                    if (sellIndex >= 0 && sellIndex < unsoldCurrentIndex) {
                        // Get the car to be sold
                        Car carToSell = unsoldCars[sellIndex];


                        System.out.print("Enter new owner's firstname: ");
                        String firstname = input.nextLine();
                        input.nextLine();

                        System.out.print("Enter new owner's lastname: ");
                        String lastname = input.nextLine();

                        System.out.print("Enter new owner's gender (MALE, FEMALE, OTHER): ");
                        String genderStr = input.nextLine();
                        Person.Gender gender = Person.Gender.valueOf(genderStr);

                        System.out.print("Enter new owner's SIN: ");
                        int SIN = input.nextInt();

                        // Create a new Person object for the owner of the car
                        Person owner = new Person(firstname, lastname, gender, SIN);

                        // Set the car's owner to the new owner and add the car to the soldCars array
                        carToSell.setOwner(owner);

                        System.out.println("Car sold successfully.");
                    } else {
                        System.out.println("Invalid car index. Please try again.");
                    }
                    break;


                    // Exit the application
                case 99:
                    System.out.println("Exiting the application.");
                    break;

                    // Invalid decision
                default:
                    System.out.println("Invalid decision. Please try again.");
            }

        } while (decision != 99);
    }
}
