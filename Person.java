import java.util.ArrayList;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    // לבדוק איך לבצע את הגישה עם סיסמא
    private String password;
    public ArrayList<Course> courses;

    //  private final ArrayList<Notification> notifications;

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
    
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void printCourses() {
        System.out.println("Your courses: ");
        for(Course course: this.courses){
            System.out.println(course.getName());
        }
    }

}
