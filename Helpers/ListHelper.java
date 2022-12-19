package Helpers;

import java.util.List;

import Models.Feedback;
import Models.Student;
import Models.Assignments;

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
