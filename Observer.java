/**
 * This interface defines the behavior of an Observer.
 * The update method is called with a message parameter, which the observer handles.
 */

public interface Observer {
    /**
     * an observer that will print the message it will get.
     * @param message
     */
    void update(String message);
    
}
