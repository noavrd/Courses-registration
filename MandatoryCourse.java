/**
 * This Java class represents a MandatoryCourse, which is a specific type of Course.
 * It extends the Course class, inheriting its attributes and methods.
 * The constructor initializes a MandatoryCourse object with the provided parameters,
 * specifying the course type as MANDATORY.
 */

import java.util.ArrayList;

public class MandatoryCourse extends Course{

    public MandatoryCourse(int id, String name, int hoursLength, int studentsLimit, ArrayList<Student> students,
            Professor professor, Metargel metargel) {
        super(id, name, hoursLength, studentsLimit, students, professor, metargel, CourseType.MANDATORY);
      
    }
    
}
