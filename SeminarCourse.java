import java.util.ArrayList;

public class SeminarCourse extends Course{

    public SeminarCourse(int id, String name, int hoursLength, int studentsLimit, ArrayList<Student> students,
            Professor professor, Metargel metargel, String type) {
        super(id, name, hoursLength, studentsLimit, students, professor, metargel, type);
    }
    
}
