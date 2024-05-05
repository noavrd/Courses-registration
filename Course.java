/**
 * Course representing a course in an educational system.
 * It includes functionality for managing course details, student enrollment, and notification handling.
 * The Course class implements the NotificationCenter interface to manage observers for notifications.
 * Additionally, an enum CourseType is included to specify the type of courses (MANDATORY, ELECTIVE, SEMINAR).
 */
import java.util.ArrayList;
import java.util.Observer;

/**
 * This enum defines the types of courses that can be offered:
 * - MANDATORY: Represents a course that students are required to take.
 * - ELECTIVE: Represents a course that students can choose to take.
 * - SEMINAR: Represents a seminar course, which may have a different format or purpose compared to regular courses.
 * I added enum to make sure only this types of classes will be excepted
 */
enum CourseType {
    MANDATORY,
    ELECTIVE,
    SEMINAR
}

public class Course implements NotificationCenter {
    private int id;
    private String name;
    private int hoursLength;
    private int studentsLimit;
    private ArrayList<Student> students;
    private Professor professor;
    private Metargel metargel;
    private CourseType type;
    private ArrayList<Person> observers;


    public Course(int id, String name, int hoursLength, int studentsLimit, ArrayList<Student> students, Professor professor, Metargel metargel, CourseType type) {
        this.id = id;
        this.name = name;
        this.hoursLength = hoursLength;
        this.studentsLimit = studentsLimit;
        this.students = new ArrayList<Student>();
        this.professor = professor;
        this.metargel = metargel;
        this.type = type;
        this.observers = new ArrayList<Person>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getHoursLength() {
        return hoursLength;
    }

    public int getStudentsLimit() {
        return studentsLimit;
    }

    public void printStudentsNames() {
        System.out.println("Registered students to " + this.name);
        for(Student student: this.students){
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    public Professor getProfessor() {
        return professor;
    }

    public Metargel getMetargel() {
        return metargel;
    }

    public CourseType getType() {
        return type;
    }


    // function to add students and remove students from this class
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void removeStudent(Student student) {
        students.remove(student);
    
    }

    // a function to check if a student can register this class
    public boolean openToRegister() {
        return students.size() < studentsLimit;
    }

    // used when deleting a course
    public void removeAllStudents( ){
        for(Student student: this.students){
            student.unRegisterToCourse(this);
         }
    }

    // Implement NotificationCenter methods
   @Override
    public void subscribe(Person observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Person observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Person observer : observers) {
            observer.update(message);
        }
    }

}
