package Interfaces;

import Helpers.ListHelper;
import Models.Student;
import Models.Feedback;
import Models.Assignment;

import java.util.List;

public class StudentInterface {
    public void showMyDashboard() {
        System.out.println("""
                \nHello, student. What do you want to do?

                1. View existing assignments
                2. View feedbacks
                3. Mark an assignment as done
                4. View my account information
                5. Logout
                """);
    }

    public void viewMyAssignments(List<Assignment> studentAssignments) {
        // See assignments
        if (!ListHelper.hasAssignments(studentAssignments))
            return;

        studentAssignments.forEach(task -> System.out.println(task.getAssignment(true)));
    }

    public void viewMyFeedbacks(List<Feedback> studentFeedbacks) {
        // See feedbacks
        if (!ListHelper.hasFeedbacks(studentFeedbacks))
            return;

        studentFeedbacks.forEach(feedback -> System.out.println(feedback.getFeedback(true)));
    }

    public void viewSelfInfo(Student student) {
        // See self account info
        student.viewSelfInfo();
    }
}
