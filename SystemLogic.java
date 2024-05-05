/**
* The courses registration main system. 
* It includes functionalities for user login, sign-in, and logout, as well as options for different user types.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class SystemLogic {
    Scanner scanner = new Scanner(System.in);

    private int capacityConnectedUsers; 
    private ArrayList<Person> currentConnectedUsers;  
    // Singleton instance of UniversityData class
    private UniversityData instance; 
    
    // Constructor to initialize system logic
    public SystemLogic() {
        this.capacityConnectedUsers = 100;
        this.currentConnectedUsers = new ArrayList<>();
        this.instance = UniversityData.getInstance();
    }

    // Method to check if the system can log in more users
    public boolean checkCapacity() {
        return currentConnectedUsers.size() < capacityConnectedUsers;
    }

    /**
     * @param id
     * @param password
     * @param firstName
     * @param lastName
     * @param userType
     * @return
     * 
     * a function that check if the user is already registered by checking for all users type if it has the given id.
     * if it's not then create new user
     */

    public boolean SignIn(int id, String password, String firstName, String lastName, String userType) {
        // check capacity
        if (!checkCapacity()) {
            System.err.println("Users capacity is full. Try again later");
            return false;
        }

        ArrayList<Student> studentsInstance = this.instance.getStudents();

        // Check if the user already exists
        for(Student student: studentsInstance) {
            if ( student.getId() == id ) {
                System.out.println("User exist. Please log in");
                return false;

            }
        }

        ArrayList<Professor> professorsInstance = this.instance.getProfessors();
        
        for(Professor professor: professorsInstance) {
            if ( professor.getId() == id ) {
                System.out.println("User exist. Please log in");
                return false;

            }
        }

        ArrayList<Metargel> metargelimInstance = this.instance.getMetargelim();
        
        for(Metargel metargel: metargelimInstance) {
            if ( metargel.getId() == id ) {
                System.out.println("User exist. Please log in");
                return false;

            }
        }

        // create new user according to the matching type
        switch (userType) {
            case "student": 
                Student student = new Student(id, firstName, lastName, password, null);
                // lastUserEntered = student;
                instance.addStudent(student);
                currentConnectedUsers.add(student);
                return true;
                
            case "professor": 
                Professor professor = new Professor(id, firstName, lastName, password, null);
                // lastUserEntered = professor;
                instance.addProfessor(professor);
                currentConnectedUsers.add(professor);

                return true;
        
            case "metargel": 
                Metargel metargel = new Metargel(id, firstName, lastName, password, null);
                // lastUserEntered = metargel;
                instance.addMetargel(metargel);
                currentConnectedUsers.add(metargel);

                return true;
        
            default:
                System.err.println("user type didn't exist. Try again");
                return false;
        }

    }

    // Method to get sign in details from user
    public void signInDetails(String currentUserType){
        System.out.print("Enter ID: ");
        int id1 = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter password: ");
        String password1 = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter user type (student/professor/metargel): ");
        String userType = scanner.nextLine();
        currentUserType = userType;
        SignIn(id1, password1, firstName, lastName, userType);
    }

    // Method to get login details from user
    public void logInDetails(String currentUserType) {
        System.out.print("Enter ID: ");
        int id2 = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter password: ");
        String password2 = scanner.nextLine();
        logIn(id2, password2, currentUserType);
    }

    // Method for user login
    public boolean logIn(int id, String password, String currentUserType){
        //check capacity
        if (!checkCapacity()) {
            System.err.println("Users capacity is full. Try again later");
            return false;
        }

        // check if id and password matching
        ArrayList<Student> studentsInstance = this.instance.getStudents();

        for(Student student: studentsInstance) {
            if (student.getId() == id && student.getPassword().equals(password)) {
                currentConnectedUsers.add(student);
                System.out.println("Welcome " + student.getFirstName() + "!");
                return true;

            }
        }

        ArrayList<Professor> professorsInstance = this.instance.getProfessors();
        
        for(Professor professor: professorsInstance) {
            if (professor.getId() == id && professor.getPassword().equals(password)) {
                currentConnectedUsers.add(professor);
                System.out.println("Welcome " + professor.getFirstName() + "!");
                return true;

            }
        }

        ArrayList<Metargel> metargelimInstance = this.instance.getMetargelim();
        
        for(Metargel metargel: metargelimInstance) {
            if (metargel.getId() == id && metargel.getPassword().equals(password)) {
                currentConnectedUsers.add(metargel);
                System.out.println("Welcome " + metargel.getFirstName() + "!");
                return true;

            }
        }

        System.err.println("Id or password incorrect. Try again");
        System.out.println("What do you want to do next?");
        System.out.println("1. Sign in");
        System.out.println("2. Log in");

        System.out.println("Enter your choice");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                signInDetails(currentUserType);
                break;

            case 2:
                logInDetails(currentUserType);
                break;

            default:
                System.out.println("Invalid choice!");

        }
        return false;
    }

    // Method for user logout
    public void logOut(int id){
        for(Person user: currentConnectedUsers){
            if(user.getId() == id){
                this.currentConnectedUsers.remove(user);
                System.out.println("Logged out successfully");
                return;
            }
        }
    }
    
    // Method to display options based on user type
    public void getOptions() {
        Person user = currentConnectedUsers.get(currentConnectedUsers.size() - 1);

        if (user instanceof Student) {
            getStudentOptions( user);
        }

       else if (user instanceof Professor) {
            getProfessorOptions(user);
        }

        else if (user instanceof Metargel) {
            getMetargelOptions(user);
        }
    }

    public void getMetargelOptions(Person user) {
        Metargel metargel = (Metargel) user;
        System.out.println("What would you like to do?");
        System.out.println("1. Watch my courses");

        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){
            case 1:
                metargel.printCourses();
                break;
            
            default:
              System.out.println("Invalid choice!");
        }

        System.out.println("What do you want to do next?");
        System.out.println("1. Continue");
        System.out.println("2. Log out");

        System.out.println("Enter your choice");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                getMetargelOptions(metargel);
                break;

            case 2:
                logOut(metargel.getId());
                break;

            default:
                System.out.println("Invalid choice!");

        }
    }

    public void getProfessorOptions(Person user) {
        Professor professor = (Professor) user;

        System.out.println("What would you like to do?");
        System.out.println("1. Create new course");
        System.out.println("2. Cancel a course");
        System.out.println("3. Watch my courses");

        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter course ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter course name: ");
                String name = scanner.nextLine();
                System.out.print("Enter hours length: ");
                String hours = scanner.nextLine();
                System.out.print("Enter studentsLimit: ");
                String limit = scanner.nextLine();
                System.out.print("Choose metargel: ");
                Metargel metargel = instance.chooseMetargel();
                System.out.print("Enter course type (mandatory/elective/seminar): ");
                String courseType = scanner.nextLine();

                Course newCourse = professor.createCourse(id, name, choice, id, metargel, courseType);
                instance.addCourse(newCourse);
                break;

            case 2:
                System.out.println("What course do you want to cancel?");
                instance.courseToDelete(professor);


            break;

            case 3:
                professor.printCourses();
            break;

            default:
                System.out.println("Invalid choice!");

        }

        System.out.println("What do you want to do next?");
        System.out.println("1. Continue");
        System.out.println("2. Log out");

        System.out.println("Enter your choice");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                getProfessorOptions(professor);
                break;

            case 2:
                logOut(professor.getId());
                break;

            default:
                System.out.println("Invalid choice!");

        }
    }


    public void getStudentOptions(Person user) {
        Student student = (Student) user;
        System.out.println("What would you like to do?");
        System.out.println("1. Register to a course");
        System.out.println("2. Cancel a course");
        System.out.println("3. Watch my courses");
        System.out.println("4. Subscribe to notifications");
        System.out.println("5. Unsubscribe to notifications");



        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("What class do you want to register?");
                instance.courseToRegister(student);

                break;

            case 2:
                System.out.println("What course do you want to cancel?");
                instance.courseToCancel(student);


            break;

            case 3:
                student.printCourses();
            break;

            case 4:
                System.out.println("What class do you want to subscribe for notification?");
                instance.courseToSubscribeOrUnsubscribe(student, true);
                break;

            case 5:
                System.out.println("What class do you want to unsubscribe for notification?");
                instance.courseToSubscribeOrUnsubscribe(student, false);
                break;

            default:
                System.out.println("Invalid choice!");

        }

        System.out.println("What do you want to do next?");
        System.out.println("1. Continue");
        System.out.println("2. Log out");

        System.out.println("Enter your choice");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                getStudentOptions(student);
                break;

            case 2:
                logOut(student.getId());
                break;

            default:
                System.out.println("Invalid choice!");

        }

    }   

}
