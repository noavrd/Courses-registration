public class Person {
    private int id;
    private String firstName;
    private String lastName;
    // לבדוק איך לבצע את הגישה עם סיסמא
    private String password;
    //  private final ArrayList<Notification> notifications;

    public Person(int id, String firstName, String lastName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

}
