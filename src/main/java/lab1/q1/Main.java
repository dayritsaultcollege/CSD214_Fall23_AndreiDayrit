package lab1.q1;

/**
 Author : Andrei Dayrit
 Date : 09/27/2023
 Description : This is the main class for the Person class and it creates 3 Person objects and prints them out.
 **/

public class Main {

    //This creates 3 Person objects and prints them out
    public static void main(String[] args) {


        // Create Person objects
        Person p1 = new Person("Andrei", "Dayrit", Person.Gender.MALE, 1234);
        Person p2 = new Person("David", "Son", Person.Gender.MALE, 5678);
        Person p3 = new Person("Angelica", "Morning", Person.Gender.FEMALE, 9101);


        // Print Person objects directly
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);


        // Prints the COUNT of each variable
        System.out.println("COUNT: " + Person.getCount());
    }
}
