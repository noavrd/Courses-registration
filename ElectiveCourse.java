import java.util.ArrayList;

public class ElectiveCourse extends Course {

    public ElectiveCourse(int id, String name, int hoursLength, int studentsLimit, ArrayList<Student> students,
            Professor professor, Metargel metargel, String type) {
        super(id, name, hoursLength, studentsLimit, students, professor, metargel, type);
    }
    
}
