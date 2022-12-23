package Helpers;

import java.util.List;

import Models.Feedback;
import Models.Student;
import Models.Assignments;

public class ListHelper {
    // checks to see if the list of feedbacks is empty,
    // and prints a message if it is.
    public static boolean hasFeedbacks(List<Feedback> list) {
        if (list.size() == 0) {
            System.out.println("""

                    ============================================
                    |   No available feedbacks at the moment   |
                    ============================================
                    """);
            return false;
        }
        return true;
    }

    // checks to see if the list of assignments is empty,
    // and prints a message if it is.
    public static boolean hasAssignments(List<Assignments> list) {
        if (list.size() == 0) {
            System.out.println("""

                    ============================================
                    |  No available assignments at the moment  |
                    ============================================
                    """);
            return false;
        }
        return true;
    }

    // checks to see if the list of students is empty, and prints a message as well
    // as the type of action that cannot be taken if it is.
    public static boolean hasStudents(List<Student> list, String type) {
        if (list.size() == 0) {
            System.out.printf("""

                    ==========================================
                    |  Cannot give %s because of 0 students  |
                    ==========================================
                    \n""", type);
            return false;
        }
        return true;
    }
}
