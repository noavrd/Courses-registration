/**
 * The definition of the Person class.
 * A Person represents an individual within the system and holds information such as ID, first name,
 * last name, password, and a list of courses they are enrolled in.
 * It implements the Observer interface to receive updates.
 */
import java.util.ArrayList;

public class Person implements Observer {
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    public ArrayList<Course> courses;

    public Person(int id, String firstName, String lastName, String password, ArrayList<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.courses = new ArrayList<Course>();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
    
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // print person courser he register to
    public void printCourses() {
        System.out.println("Your courses: ");
        for(Course course: this.courses){
            System.out.println(course.getName());
        }
    }

     @Override
    public void update(String message) {
        System.out.println("New message: " + message);
    }

}
