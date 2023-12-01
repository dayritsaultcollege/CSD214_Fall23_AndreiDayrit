//package test1_practical;
//import java.util.Scanner;
//
//import static java.awt.SystemColor.menu;
//
//public class App {
//
//    private Scanner input = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        App app = new App();
//        app.run();
//    }
//
//    public void run() {
//        String menu = "Menu"
//                + "----------------------\n"
//                + " 1. Add a Course\n"
//                + " 2. Edit a course\n"
//                + " 3. List courses\n"
//                + " Enter a choice:\n"
//                + "----------------------\n";
//    }
//
//    int decision;
//     do{
//        System.out.println(menu);
//        //input for the user to decide what to do
//        System.out.print("Enter your decision: ");
//        decision = input.nextInt();
//        input.nextLine();
//
//        switch (decision) {
//
//            //If the user choose to add Course
//            case 1:
//            System.out.println("Enter the course you want to add: ");
//            String make = input.nextLine();
//
//            System.out.println("Enter the Code: ");
//            String code = input.nextLine();
//
//            System.out.println("Enter the Course Name: ");
//            String name = input.nextLine();
//
//            System.out.println("Enter the StartDate: ");
//            String startDate = input.nextLine();
//
//            System.out.println("Enter the Number of Students: ");
//            String numberOfStudents = input.nextLine();
//
//            System.out.println("Enter the Count: ");
//            String count = input.nextLine();
//
//
//            //Edit Course
//            case 2:
//
//            //List Course
//            case 3:
//
//        }
//    }
//}
