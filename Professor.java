import java.util.ArrayList;

public class Professor extends Person {

    public Professor(int id, String firstName, String lastName, String password, ArrayList<Course> courses) {
        super(id, firstName, lastName, password, courses);
    }

    public Course createCourse(int id, String name, int hoursLength, int studentsLimit, Metargel metargel, CourseType type) {
        Course newCourse = new Course(id, name, hoursLength, studentsLimit, null, this, metargel, type);
        courses.add(newCourse);
        return newCourse;
    }

    // when deleting course it will remove all the students and remove the course from the metargel and professor courses.
    public void deleteCourse(Course course) {
        course.removeAllStudents();
        course.getMetargel().courses.remove(course);
        this.courses.remove(course);
    }
    
}
