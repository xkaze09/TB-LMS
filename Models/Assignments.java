package Models;

public class Assignments {
    private final String studentName;
    private final String teacherName;
    private String assignment;

    // Constructor to create an Assignments object with studentName, teacherName and
    // assignment
    public Assignments(String studentName, String teacherName, String assignment) {
        this.studentName = studentName;
        this.teacherName = teacherName;
        this.assignment = assignment;
    }

    // Returns a String with the assignment details based on whether the user is a
    // student or teacher
    public String getAssignment(boolean isStudent) {
        return (isStudent) ? String.format("""
                \nFrom Instructor %s: %s
                """, teacherName, assignment) : String.format("""
                \nGiven to Mr./Ms. %s: %s
                """, studentName, assignment);

    }

    // Adds the string [COMPLETED] to the assignment if it is not already present
    public void markAsCompleted() {
        String completed = " [COMPLETED]";
        if (!assignment.contains(completed))
            assignment += completed;
        else
            System.out.println("""

                    =======================================
                    |  Assignment is marked as COMPLETED  |
                    =======================================
                    """);
    }

    @Override
    // returns a String object of the studentName, teacherName and assignment
    public String toString() {
        return studentName + "," + teacherName + "," + assignment;
    }

}
