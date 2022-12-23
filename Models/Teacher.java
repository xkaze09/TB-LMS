package Models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Helpers.FileHelper;

public class Teacher extends User {
    private static final File feedbacksCSV = new File("./Database/CSV/feedbacks.csv");
    private static final File assignmentsCSV = new File("./Database/CSV/assignments.csv");
    private final List<Feedback> givenFeedbacks = new ArrayList<>();
    private final List<Assignments> givenAssignments = new ArrayList<>();

    /*
     * Constructor for the Teacher class that sets fields from a UserBuilder object
     * and checks for existing feedbacks and assignments from CSV files
     */
    public Teacher(UserBuilder builder) {
        this.setFirstName(builder.getFirstName());
        this.setLastName(builder.getLastName());
        this.setUsername(builder.getUsername());
        this.setPassword(builder.getPassword());
        this.setAge(builder.getAge());
        this.setType(builder.getType());
        FileHelper.checkForFeedbacks(feedbacksCSV, givenFeedbacks);
        FileHelper.checkForAssignments(assignmentsCSV, givenAssignments);
    }

    // Returns the list of feedbacks given by a teacher
    public List<Feedback> getGivenFeedbacks() {
        return givenFeedbacks;
    }

    // Returns the list of assignments given by a teacher
    public List<Assignments> getGivenAssignments() {
        return givenAssignments;
    }

    // Returns the feedbacks CSV file
    public File getFeedbacksCSV() {
        return feedbacksCSV;
    }

    // Returns the assignments CSV file
    public File getAssignmentsCSV() {
        return assignmentsCSV;
    }

}
