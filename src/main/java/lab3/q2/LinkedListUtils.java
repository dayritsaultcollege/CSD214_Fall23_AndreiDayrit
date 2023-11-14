package lab3.q2;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListUtils {
    public static void reverse(LinkedList<String> strings) {

        // Reverse the list using the Collections class
        Collections.reverse(strings);
    }


    // Test the reverse method by creating a list of strings and calling the method
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("Orange");
        strings.add("Apple");
        strings.add("Cranberry");
        strings.add("Banana");
        strings.add("Strawberry");

        System.out.println("Original list:");
        for (String str : strings) {
            System.out.println(str);
        }

        reverse(strings);

        // Print the reversed list
        System.out.println("\nReversed list:");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
