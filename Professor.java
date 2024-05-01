import java.util.ArrayList;

public class Professor extends Person {

    public Professor(int id, String firstName, String lastName, String password, ArrayList<Course> courses) {
        super(id, firstName, lastName, password, courses);
    }

    // public void createCourse(int id, String name, int hoursLength, int studentsLimit, Metargel metargel, String type) {

    //     Course newCourse = null;

    //     if (type.equals("mandatory")) {
    //         Course newCourse = new MandatoryCourse(id, name, hoursLength, studentsLimit, null, this, metargel, CourseType.MANDATORY);


        

    // } else if (type.equals("seminar")) {
    //     Course newCourse = new SeminarCourse(id, name, hoursLength, studentsLimit, null, this, metargel, CourseType.SEMINAR);


        

    // } else if (type.equals("elective")) {
    //     Course newCourse = new ElectiveCourse(id, name, hoursLength, studentsLimit, null, this, metargel, CourseType.ELECTIVE);


    //     }

    //     if (newCourse != null) {
    //         courses.add(newCourse);
    //     }
    //     // Course newCourse = new Course(id, name, hoursLength, studentsLimit, null, this, metargel, type);
    //     // return newCourse;
    // }

    // when deleting course it will remove all the students and remove the course from the metargel and professor courses.
    public void deleteCourse(Course course) {
        course.removeAllStudents();
        course.getMetargel().courses.remove(course);
        this.courses.remove(course);
    }
    
}
