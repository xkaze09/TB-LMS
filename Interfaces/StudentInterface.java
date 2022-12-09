package Interfaces;

import Models.Student;

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

    public void viewMyAssignments() {
        // See assignments

    }

    public void viewMyFeedbacks() {
        // See feedbacks
    }

    public void viewSelfInfo(Student student) {
        // See self account info
    }
}
