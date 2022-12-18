package Models;

import Helpers.FileHelper;

// For reading CSV files
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private static final File feedbacksCSV = new File("./Database/CSV/feedbacks.csv");
    private static final File assignmentsCSV = new File("./Database/CSV/assignments.csv");
    private final List<Feedback> givenFeedbacks = new ArrayList<>();
    private final List<Assignment> givAssignments = new ArrayList<>();

    public Teacher(UserBuilder builder) {
        this.setFirstName(builder.getFirstName());
        this.setLastName(builder.getLastName());
        this.setUsername(builder.getUsername());
        this.setPassword(builder.getPassword());
        this.setAge(builder.getAge());
        this.setType(builder.getType());
        FileHelper.checkForFeedbacks(feedbacksCSV, givenFeedbacks);
        FileHelper.checkForAssignments(assignmentsCSV, givAssignments);
    }
    // To-do list:
    // Teacher must be able to do the following:
    // a. Create and check assignments
    // b. Create and check feedbacks
}
