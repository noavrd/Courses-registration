import java.util.ArrayList;

public class Student extends Person{

    private ArrayList<Course> courses;

    public Student(int id, String firstName, String lastName, String password, Course courses) {
        super(id, firstName, lastName, password);
        this.courses = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    public void registerToCourse(Course course){
        course.addStudent(this);
    }

    public void unRegisterToCourse(Course course){
        course.removeStudent(this);
    }
}
