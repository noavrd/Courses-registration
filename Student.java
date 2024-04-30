import java.util.ArrayList;

public class Student extends Person{


    public Student(int id, String firstName, String lastName, String password, ArrayList<Course> courses) {
        super(id, firstName, lastName, password, courses);
    }

    
    public void registerToCourse(Course course){
        course.addStudent(this);
        courses.add(course);
    }

    // function to remove student from the course. it will first remove the student from the course student list and then remove the course from the student courses    public void unRegisterToCourse(Course course){
        public void unRegisterToCourse(Course course){
        course.removeStudent(this);
        courses.remove(course);
    }

}
