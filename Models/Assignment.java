package Models;

public class Assignment {
    private final String studentName;
    private final String teacherName;
    private String assignment;

    public Assignment(String studentName, String teacherName, String assignment) {
        this.studentName = studentName;
        this.teacherName = teacherName;
        this.assignment = assignment;
    }

    public String getAssignment(boolean isStudent) {
        return (isStudent) ? String.format("""
                \nFrom Instructor %s: {
                %s
                }
                """, teacherName, assignment) : String.format("""
                \nGiven to Mr./Ms. %s: {
                %s
                }
                """, studentName, assignment);

    }

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
    public String toString() {
        return studentName + "," + teacherName + "," + assignment;
    }

}
