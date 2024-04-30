import java.util.ArrayList;

public class UniversityData {

    // שימוש ביוניבסטי דאטה מאפשר לנו להשתמש בתבנית עיצוב singelton
    // וכך מאפשרת שימוש יחיד ובלעדי ביוניבריסטי דאטה

    private static UniversityData instance = null;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Metargel> metargelim;

    private UniversityData(){
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.metargelim = new ArrayList<>();}

    public static UniversityData getInstance(){
        if(instance == null){
            instance = new UniversityData();
        }
        return instance;
    }

}
