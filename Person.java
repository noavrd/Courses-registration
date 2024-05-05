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
