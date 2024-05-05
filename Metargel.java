/**
 * This Java class represents a Metargel, a type of Person in the system.
 * It extends the Person class and initializes a Metargel object with the given parameters.
 * Metargelim assist in teaching courses and may have associated courses they are involved in.
 */

import java.util.ArrayList;

public class Metargel extends Person{

    public Metargel(int id, String firstName, String lastName, String password, ArrayList<Course> courses) {
        super(id, firstName, lastName, password, courses);
    }
    
}
