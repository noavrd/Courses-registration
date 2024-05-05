/**
 * This Java class represents an ElectiveCourse, which is a specific type of Course.
 * It extends the Course class, inheriting its attributes and methods.
 * The constructor initializes an ElectiveCourse object with the provided parameters,
 * specifying the course type as ELECTIVE.
 */

import java.util.ArrayList;

public class ElectiveCourse extends Course {

    public ElectiveCourse(int id, String name, int hoursLength, int studentsLimit, ArrayList<Student> students,
            Professor professor, Metargel metargel) {
        super(id, name, hoursLength, studentsLimit, students, professor, metargel, CourseType.ELECTIVE);
    }
    
}
