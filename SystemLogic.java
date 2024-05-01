import java.util.ArrayList;
import java.util.Scanner;

    /**
     * The courses registration main system. 
     * In here we have all the users log in, sign in and log out functions.
     */

public class SystemLogic {
    Scanner scanner = new Scanner(System.in);

    private int capacityConnectedUsers; 
    private ArrayList<Person> currentConnectedUsers;  
    private UniversityData instance; 
    // private Person lastUserEntered;
    
    public SystemLogic() {
        this.capacityConnectedUsers = 100;
        this.currentConnectedUsers = new ArrayList<>();
        this.instance = UniversityData.getInstance();
        // this.lastUserEntered = null;
    }

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
        if (!checkCapacity()) {
            System.err.println("Users capacity is full. Try again later");
            return false;
        }

        ArrayList<Student> studentsInstance = this.instance.getStudents();

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



    public boolean logIn(int id, String password){
        if (!checkCapacity()) {
            System.err.println("Users capacity is full. Try again later");
            return false;
        }

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
        return false;

    }

    public void logOut(int id){
        for(Person user: currentConnectedUsers){
            if(user.getId() == id){
                this.currentConnectedUsers.remove(user);
                System.out.println("Logged out successfully");
                return;
            }
        }
    }
    
    public void getOptions() {
        Person user = currentConnectedUsers.get(currentConnectedUsers.size() - 1);

        if (user instanceof Student) {
            getStudentOptions( user);
        }

        // if (user instanceof Professor) {
        //     getProfessorOptions(user);
        // }
    }

    // public void getProfessorOptions(Person user) {
    //     Professor professor = (Professor) user;

    //     System.out.println("What would you like to do?");
    //     System.out.println("1. Create new course");
    //     System.out.println("2. Cancel a course");
    //     System.out.println("3. Watch my courses");

    //     System.out.println("Enter your choice:");
    //     int choice = scanner.nextInt();
    //     scanner.nextLine();

    //     switch (choice) {
    //         case 1:
    //         System.out.print("Enter course ID: ");
    //         int id = scanner.nextInt();
    //         scanner.nextLine(); // consume newline
    //         System.out.print("Enter course name: ");
    //         String name = scanner.nextLine();
    //         System.out.print("Enter hours length: ");
    //         String hours = scanner.nextLine();
    //         System.out.print("Enter studentsLimit: ");
    //         String limit = scanner.nextLine();
    //         System.out.print("Choose metargel: ");
    //         Metargel metargel = instance.chooseMetargel();
    //         System.out.print("Enter course type (mandatory/elective/seminar): ");
    //         String courseType = scanner.nextLine();

    //             // professor.createCourse(id, name, choice, id, metargel, courseType);
            



    //         // currentUserType = userType;
    //         // professor.createCourse(id, name, choice, id, metargel, courseType.toUpperCase());
               
    //             break;

    //         case 2:
    //             System.out.println("What course do you want to cancel?");
    //             instance.courseToCancel(professor);


    //         break;

    //         case 3:
    //             professor.printCourses();
    //         break;

    //         default:
    //             System.out.println("Invalid choice!");

    //     }

    // }


    public void getStudentOptions(Person user) {
        Student student = (Student) user;
        System.out.println("What would you like to do?");
        System.out.println("1. Register to a course");
        System.out.println("2. Cancel a course");
        System.out.println("3. Watch my courses");

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

            default:
                System.out.println("Invalid choice!");

        }

        System.out.println("Do you want to continue?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.println("Enter your choice");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                getStudentOptions(student);
                break;

            case 2:
            break;

            default:
                System.out.println("Invalid choice!");

        }

    }   

}
