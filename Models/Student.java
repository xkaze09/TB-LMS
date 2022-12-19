package Models;

import java.util.ArrayList;
import java.util.List;

import Controllers.StudentController;

public class Student extends User {
    private final List<Feedback> myFeeds = new ArrayList<>();
    private final List<Assignments> myFeedbacks = new ArrayList<>();
    private StudentController myController;

    public Student(UserBuilder builder) {
        this.setFirstName(builder.getFirstName());
        this.setLastName(builder.getLastName());
        this.setUsername(builder.getUsername());
        this.setPassword(builder.getPassword());
        this.setAge(builder.getAge());
        this.setType(builder.getType());
    }

    public List<Feedback> getMyFeedbacks() {
        return myFeeds;
    }

    public List<Assignments> getMyAssignments() {
        return myFeedbacks;
    }

    public StudentController getMyController() {
        return myController;
    }

    public void setMyController(StudentController myController) {
        this.myController = myController;
    }
}
