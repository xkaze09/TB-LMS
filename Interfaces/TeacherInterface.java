package Interfaces;

import Helpers.ListHelper;
import Models.Feedback;
import Models.Assignment;
import Models.Teacher;

import java.util.List;

public class TeacherInterface {
    public void showMyDashboard() {
        System.out.println("""
                \nHello, teacher. What do you want to do?

                1. Give feedback to a student
                2. Create an assignment for a student
                3. Delete an assignment
                4. Delete a feedback
                5. View my account information
                6. View given feedbacks
                7. View given assignments
                8. Logout
                """);
    }

    public void viewGivenFeedbacks(List<Feedback> teacherGivenFeedbacks) {
        // See given feedbacks
        if (!ListHelper.hasFeedbacks(teacherGivenFeedbacks))
            return;
        teacherGivenFeedbacks.forEach(feedback -> System.out.println(feedback.getFeedback(false)));
    }

    public void viewGivenAssignments(List<Assignment> teacherGivenAssignments) {
        // See given assignments
        if (!ListHelper.hasAssignments(teacherGivenAssignments))
            return;
        teacherGivenAssignments.forEach(task -> System.out.println(task.getAssignment(false)));
    }

    public void viewSelfInfo(Teacher teacher) {
        // See self account info
        teacher.viewSelfInfo();
    }
}
