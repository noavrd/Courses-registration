import java.util.ArrayList;

public class SystemLogic {
    private int capacityConnectedUsers; 
    private ArrayList<Person> currentConnectedUsers;  
    private UniversityData instance; 
    
    public SystemLogic() {
        this.capacityConnectedUsers = 100;
        this.currentConnectedUsers = new ArrayList<>();
        this.instance = UniversityData.getInstance();
    }
}
