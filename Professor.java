/**
 * A Professor is a type of Person who has the ability to create and delete courses.
 * Professors inherit properties and methods from the Person class.
 */
import java.util.ArrayList;

public class Professor extends Person {

    public Professor(int id, String firstName, String lastName, String password, ArrayList<Course> courses) {
        super(id, firstName, lastName, password, courses);
    }


    // A method to create new classes - only professor can do this
    public Course createCourse(int id, String name, int hoursLength, int studentsLimit, Metargel metargel, String type) {
        Course newCourse = null;

        // check if course name already exist for that professor
        for (Course course: courses) {
            System.out.println(course.getName());


            if (course.getName().equals(name)){
                System.out.println("Course already exist, can't create another one");
                return null;
            }
        }
       
        if (type.equals("mandatory")) {
            newCourse = new MandatoryCourse(id, name, hoursLength, studentsLimit, new ArrayList<>(), this, metargel);
        } else if (type.equals("seminar")) {
            newCourse = new SeminarCourse(id, name, hoursLength, studentsLimit, new ArrayList<>(), this, metargel);
        } else if (type.equals("elective")) {
            newCourse = new ElectiveCourse(id, name, hoursLength, studentsLimit, new ArrayList<>(), this, metargel);
        }
        if (newCourse != null) {
            courses.add(newCourse);
        }

        return newCourse;

    }

    // when deleting course it will remove all the students and remove the course from the metargel and professor courses.
    public void deleteCourse(Course course) {
        course.removeAllStudents();
        course.getMetargel().courses.remove(course);
        this.courses.remove(course);
    }
    
}
