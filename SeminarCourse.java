/**
 * This file contains the definition of the SeminarCourse class.
 * SeminarCourse is a subclass of Course, representing a specific type of course within the system.
 */

 import java.util.ArrayList;

public class SeminarCourse extends Course {

    public SeminarCourse(int id, String name, int hoursLength, int studentsLimit, ArrayList<Student> students,
            Professor professor, Metargel metargel) {
        super(id, name, hoursLength, studentsLimit, students, professor, metargel, CourseType.SEMINAR);
    }
    
}
