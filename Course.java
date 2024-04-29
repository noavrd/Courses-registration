import java.util.ArrayList;

public class Course {
    private int id;
    private String name;
    private int hoursLength;
    private int studentsLimit;
    private ArrayList<Student> students;
    private Professor professor;
    private Metargel metargel;
    private String type;

    public Course(int id, String name, int hoursLength, int studentsLimit, ArrayList<Student> students, Professor professor, Metargel metargel, String type) {
        this.id = id;
        this.name = name;
        this.hoursLength = hoursLength;
        this.studentsLimit = studentsLimit;
        this.students = new ArrayList<Student>();
        this.professor = professor;
        this.metargel = metargel;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getHoursLength() {
        return hoursLength;
    }

    public int getStudentsLimit() {
        return studentsLimit;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Metargel getMetargel() {
        return metargel;
    }

    public String getType() {
        return type;
    }


    // function to add students and remove students from this class
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // a function to check if a student can register this class
    public boolean openToRegister(){
        return students.size() < studentsLimit;
    }
}
