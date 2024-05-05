import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SystemLogic system = new SystemLogic();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            boolean firstTime = true;
            if ( firstTime ){
                System.out.println("Welcome to course registration system! ");
                firstTime = false;
            } 
            System.out.println("What would you like to do?");

            System.out.println("1. Sign In");
            System.out.println("2. Log In");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            String currentUserType = "";
            switch (choice) {
                case 1:
                    system.signInDetails(currentUserType);
                    break;

                case 2:
                    system.logInDetails(currentUserType);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

           system.getOptions();
            exit = true;

        }

        scanner.close();
    }
}
