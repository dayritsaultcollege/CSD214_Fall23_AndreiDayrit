package lab3.q1;

import java.util.LinkedList;

public class EmployeeListUtils {
    public static void downsize(LinkedList<String> employeeNames, int n) {

        // Check if n is valid (greater than 1)
        if (n <= 1) {
            System.out.println("Invalid value of n. It must be greater than 1.");
            return;
        }

        int size = employeeNames.size();
        int index = n - 1;  // Initial index to remove elements
        while (size > 0) {

            // Remove the employee at the current index and update the list
            employeeNames.remove(index);


            size--;
            index += n - 1;

            // If the index exceeds the size, wrap around to the beginning of the list
            if (index >= size) {
                index %= size;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> employeeNames = new LinkedList<>();
        employeeNames.add("Peter");
        employeeNames.add("Andrew");
        employeeNames.add("Bob");
        employeeNames.add("Fred");
        employeeNames.add("Gregory");

        downsize(employeeNames, 2);

        // Print the remaining employees

        System.out.println("Remaining employees:");
        for (String name : employeeNames) {
            System.out.println(name);
        }
    }
}
