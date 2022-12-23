package Models;

// imports from Java
import java.util.ArrayList;
import java.util.List;

// imports from package
import Controllers.StudentController;

public class Student extends User {
    private final List<Feedback> myFeeds = new ArrayList<>();
    private final List<Assignments> myFeedbacks = new ArrayList<>();
    private StudentController myController;

    /*
     * Constructs a Student object using the data from the provided UserBuilder
     * object.
     */
    public Student(UserBuilder builder) {
        this.setFirstName(builder.getFirstName());
        this.setLastName(builder.getLastName());
        this.setUsername(builder.getUsername());
        this.setPassword(builder.getPassword());
        this.setAge(builder.getAge());
        this.setType(builder.getType());
    }

    // Retrieves a list of all the feedbacks associated with the student.
    public List<Feedback> getMyFeedbacks() {
        return myFeeds;
    }

    // Retrieves a list of all the assignments associated with the student.
    public List<Assignments> getMyAssignments() {
        return myFeedbacks;
    }

    // Retrieves the StudentController object associated with the student.
    public StudentController getMyController() {
        return myController;
    }

    // Sets the StudentController object associated with the student.
    public void setMyController(StudentController myController) {
        this.myController = myController;
    }
}
