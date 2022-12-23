package Models;

public class Feedback {
    private final String feedback;
    private final String studentName;
    private final String teacherName;

    // Constructor to assign values to the studentName, teacherName, and feedback
    // fields
    public Feedback(String studentName, String teacherName, String feedback) {
        this.studentName = studentName;
        this.teacherName = teacherName;
        this.feedback = feedback;
    }

    // Returns a String with the feedback details based on whether the user is a
    // student or teacher
    public String getFeedback(boolean isStudent) {
        return (isStudent) ? String.format("""
                \nFrom Mr./Ms. %s: %s
                """, teacherName, feedback) : String.format("""
                \nTo Mr./Ms. %s: %s
                """, studentName, feedback);

    }

    @Override
    // Returns a String object of the studentName, teacherName and feedback
    public String toString() {
        return studentName + "," + teacherName + "," + feedback;
    }

}
