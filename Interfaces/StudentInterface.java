package Interfaces;

import java.util.List;

import Helpers.ListHelper;
import Models.Feedback;
import Models.Student;
import Models.Assignments;

public class StudentInterface {
    // Displays the dashboard menu for the student user.
    public void showMyDashboard() {
        System.out.println("""

                TB-LMS >>   Hello, student. What do you want to do?

                1. View existing assignments
                2. View feedbacks
                3. Mark an assignment as complete
                4. View my account information
                5. Logout
                """);
    }

    // Displays a list of the student's assignments.
    public void viewMyAssignments(List<Assignments> studentTasks) {
        if (!ListHelper.hasAssignments(studentTasks))
            return;

        studentTasks.forEach(task -> System.out.println(task.getAssignment(true)));
    }

    // Displays a list of the student's feedbacks.
    public void viewMyFeedbacks(List<Feedback> studentFeedbacks) {
        if (!ListHelper.hasFeedbacks(studentFeedbacks))
            return;

        studentFeedbacks.forEach(feedback -> System.out.println(feedback.getFeedback(true)));
    }

    // Displays the student's information.
    public void viewMyInfo(Student student) {
        student.viewMyInfo();
    }
}
