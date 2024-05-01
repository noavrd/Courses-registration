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
            // System.out.println("3. Log Out");
            // System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String currentUserType = "";
            switch (choice) {
                case 1:
                    system.signInDetails(currentUserType);
                    break;

                case 2:
                    system.logInDetails(currentUserType);
                    break;

                // case 3:
                //     System.out.print("Enter ID: ");
                //     int id3 = scanner.nextInt();
                //     system.logOut(id3);
                //     break;

                // case 4:
                //     exit = true;
                //     break;

                default:
                    System.out.println("Invalid choice!");
            }

           system.getOptions();
            exit = true;

        }

        scanner.close();
    }
}
