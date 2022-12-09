package Interfaces;

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

    public void viewGivenFeedbacks() {
        // See given feedbacks
    }

    public void viewGivenAssignments() {
        // See given assignments
    }

    public void viewSelfInfo() {
        // See self account info
    }
}
