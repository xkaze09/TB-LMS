package Helpers;

import Models.Feedback;
import Models.Student;
import Models.Assignment;

import java.util.List;

public class ListHelper {
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

    public static boolean hasAssignments(List<Assignment> list) {
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
