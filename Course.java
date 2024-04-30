import java.util.ArrayList;

// הוספתי אינום על מנת לוודא שאכן יתקבל רק אחד מ3 סוגי הקורסים ולא סוג אחר בטעות
enum CourseType {
    MANDATORY,
    ELECTIVE,
    SEMINAR
}

public class Course {
    private int id;
    private String name;
    private int hoursLength;
    private int studentsLimit;
    private ArrayList<Student> students;
    private Professor professor;
    private Metargel metargel;
    private CourseType type;

    public Course(int id, String name, int hoursLength, int studentsLimit, ArrayList<Student> students, Professor professor, Metargel metargel, CourseType type) {
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

    public void printStudentsNames() {
        System.out.println("Registered students to " + this.name);
        for(Student student: this.students){
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    public Professor getProfessor() {
        return professor;
    }

    public Metargel getMetargel() {
        return metargel;
    }

    public CourseType getType() {
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
    public boolean openToRegister() {
        return students.size() < studentsLimit;
    }

    // used when deleting a course
    public void removeAllStudents( ){
        for(Student student: this.students){
            student.unRegisterToCourse(this);
         }
    }
}
