package Interfaces;

import java.util.List;

import Helpers.ListHelper;
import Models.Feedback;
import Models.Assignments;
import Models.Teacher;

public class TeacherInterface {
    public void showMyDashboard() {
        System.out.println("""

                TB-LMS >>   Hello, teacher. What do you want to do?

                1. Give feedback to a student
                2. Create an assignment for a student
                3. Clear assignments
                4. Clear feedbacks
                5. View my account information
                6. View given feedbacks
                7. View given assignments
                8. Logout
                """);
        System.out.print(": ");
    }

    public void viewGivenFeedbacks(List<Feedback> teacherGivenFeedbacks) {
        if (!ListHelper.hasFeedbacks(teacherGivenFeedbacks))
            return;
        teacherGivenFeedbacks.forEach(feedback -> System.out.println(feedback.getFeedback(false)));
    }

    public void viewGivenAssignments(List<Assignments> teacherGivenAssignments) {
        if (!ListHelper.hasAssignments(teacherGivenAssignments))
            return;
        teacherGivenAssignments.forEach(assignment -> System.out.println(assignment.getAssignment(false)));
    }

    public void viewMyInfo(Teacher teacher) {
        teacher.viewMyInfo();
    }
}
