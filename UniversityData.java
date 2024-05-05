/** The UniversityData class serves as a repository for storing information about the
* university's courses, students, professors, and metargelim.
* It implements the Singleton design pattern to ensure a single and exclusive instance of UniversityData throughout the system.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityData {
    Scanner scanner = new Scanner(System.in);

    // Singleton instance
    private static UniversityData instance = null;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Metargel> metargelim;

    // use this incase you don't want any mock data
    // private UniversityData(){
    //     this.courses = new ArrayList<>();
    //     this.students = new ArrayList<>();
    //     this.professors = new ArrayList<>();
    //     this.metargelim = new ArrayList<>();
    // }


    // Private constructor to initialize UniversityData with mock data
    private UniversityData() {
        Professor professor1 = new Professor(1, "eli", "ron", "1", new ArrayList<>());
        Professor professor2 = new Professor(2, "jane", "gal", "1", new ArrayList<>());
        Professor professor3 = new Professor(3, "ela", "bor", "1", new ArrayList<>());
    
        // Create metargelim
        Metargel metargel1 = new Metargel(4, "roni", "mil", "1", new ArrayList<>());
        Metargel metargel2 = new Metargel(5, "dani", "cl", "1", new ArrayList<>());
        Metargel metargel3 = new Metargel(6, "nora", "ja", "1", new ArrayList<>());
    
        // Create CourseType enum instances
        CourseType mandatory = CourseType.MANDATORY;
        CourseType elective = CourseType.ELECTIVE;
        CourseType seminar = CourseType.SEMINAR;
    
        // Create three new courses
        Course course1 = new Course(1, "Mavo", 30, 50, new ArrayList<>(), professor1, metargel1, mandatory);
        Course course2 = new Course(2, "Algorithms", 45, 40, new ArrayList<>(), professor2, metargel2, elective);
        Course course3 = new Course(3, "Infi", 20, 20, new ArrayList<>(), professor3, metargel3, seminar);
    
        // Initialize the ArrayLists
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.metargelim = new ArrayList<>();
    
        // Add professors to the list
        professors.add(professor1);
        professors.add(professor2);
        professors.add(professor3);
    
        // Add metargelim to the list
        metargelim.add(metargel1);
        metargelim.add(metargel2);
        metargelim.add(metargel3);
    
        // Add courses to the list
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }
    
    public static UniversityData getInstance(){
        if(instance == null){
            instance = new UniversityData();
        }

        return instance;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }
    
    public ArrayList<Metargel> getMetargelim() {
        return metargelim;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addMetargel(Metargel metargel) {
        metargelim.add(metargel);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    // Method to choose a metargel
    public Metargel chooseMetargel() {
        for ( int i = 0; i < metargelim.size(); i++ ) {
            int courseNum = i + 1;
            System.out.println( courseNum + " " + metargelim.get(i).getFirstName() + " " + metargelim.get(i).getLastName());
        }

        System.out.println("Enter your choice:");
        int currentChoice = scanner.nextInt() - 1;
        Metargel chosen = metargelim.get(currentChoice);
        return chosen;
    }
    
    // Method to choose a course to register for
    public void courseToRegister(Student student) {
        for ( int i = 0; i < courses.size(); i++ ) {
            int courseNum = i + 1;
            System.out.println( courseNum + " " + courses.get(i).getName());
        }

        System.out.println("Enter your choice:");
        int currentChoice = scanner.nextInt() - 1;
        Course chosen = courses.get(currentChoice);
        if (chosen.openToRegister()) {
            student.registerToCourse(chosen);    
        }

    

    }

    // Method to choose a course to cancel for a single student 
    public void courseToCancel(Student student) {
        for ( int i = 0; i < student.courses.size(); i++ ) {
            int courseNum = i + 1;
            System.out.println( courseNum + " " + student.courses.get(i).getName());
        }


        System.out.println("Enter your choice:");
        int currentChoice = scanner.nextInt() - 1;
        Course chosen = student.courses.get(currentChoice);
        
        boolean close = !chosen.openToRegister(); 
        student.unRegisterToCourse(chosen);   
        
        // check if course was close to register before cancellation and if now is open because a student unregistered.
        // if so send notification it's open to register again to students that registered to this course
        if (close && chosen.openToRegister()) {
            String message = chosen.getName() + " is now open to register!";
            chosen.notify(message);
        }
        
    }

    // Method to cancel a course completely
    public void courseToDelete(Professor professor) {
        for ( int i = 0; i < professor.courses.size(); i++ ) {
            int courseNum = i + 1;
            System.out.println( courseNum + " " + professor.courses.get(i).getName());
        }

        System.out.println("Enter your choice:");
        int currentChoice = scanner.nextInt() - 1;
        Course chosen = professor.courses.get(currentChoice);
        professor.deleteCourse(chosen);
    }

    // Method to subscribe or unsubscribe to course notifications
    public void courseToSubscribeOrUnsubscribe(Student student, boolean subscribe) {
        for ( int i = 0; i < courses.size(); i++ ) {
            int courseNum = i + 1;
            System.out.println( courseNum + " " + courses.get(i).getName());
        }

        System.out.println("Enter your choice:");
        int currentChoice = scanner.nextInt() - 1;
        Course chosen = courses.get(currentChoice);
        if (subscribe) {
            chosen.subscribe(student);
        } else {
            chosen.unsubscribe(student);
        }

    }

}
