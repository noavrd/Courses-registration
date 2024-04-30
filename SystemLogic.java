import java.util.ArrayList;

    /**
     * The courses registration main system. 
     * In here we have all the users log in, sign in and log out functions.
     */

public class SystemLogic {
    private int capacityConnectedUsers; 
    private ArrayList<Person> currentConnectedUsers;  
    private UniversityData instance; 
    
    public SystemLogic() {
        this.capacityConnectedUsers = 100;
        this.currentConnectedUsers = new ArrayList<>();
        this.instance = UniversityData.getInstance();
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
                instance.addStudent(student);
                return true;
                
            case "professor": 
                Professor professor = new Professor(id, firstName, lastName, password, null);
                instance.addProfessor(professor);
                return true;
        
            case "metargel": 
                Metargel metargel = new Metargel(id, firstName, lastName, password, null);
                instance.addMetargel(metargel);
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
}
