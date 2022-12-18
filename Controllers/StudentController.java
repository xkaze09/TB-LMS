package Controllers;

import Helpers.ListHelper;
import Models.Feedback;
import Models.Student;
import Models.Assignment;
import Interfaces.StudentInterface;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final Student student;
    private final StudentInterface studentInterface = new StudentInterface();
    private final List<Feedback> studentFeedbacks;
    private final List<Assignment> studentAssignments;
    private final Scanner scan = new Scanner(System.in);

    public StudentController(Student student) {
        this.student = student;
        studentFeedbacks = student.getMyFeedbacks();
        studentAssignments = student.getMyAssignments();
        student.setMyController(this);
    }

    public void start() {
        chooseFromDashboard();
    }

    private void chooseFromDashboard() {
        while (true) {
            studentInterface.showMyDashboard();
            String input = scan.nextLine().trim();

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1 -> studentInterface.viewMyAssignments(studentAssignments);
                case 2 -> studentInterface.viewMyFeedbacks(studentFeedbacks);
                case 3 -> markAssignment();
                case 4 -> studentInterface.viewSelfInfo(student);
                case 5 -> {
                    return;
                }
            }
        }
    }

    private void markAssignment() {
        int i = 0;

        if (!ListHelper.hasAssignments(studentAssignments))
            return;

        System.out.println("""
                WARNING: Marking an assignment as done will not be saved when you exit.
                Hence, when you log back again, you won't see [COMPLETED] with it.
                """);

        for (var assignment : studentAssignments) {
            System.out.println(i + ": " + assignment.getAssignment(true));
            i++;
        }

        System.out.print("Enter the assignment you want to mark as completed: ");
        int index = Integer.parseInt(scan.nextLine());

        studentAssignments.get(index).markAsCompleted();
    }

    // for the student to also have a reference to the given assignment
    public void acceptAssignment(Assignment assignment) {
        studentAssignments.add(assignment);
    }

    // for the student to also have a reference to the given feedback
    public void acceptFeedback(Feedback feedback) {
        studentFeedbacks.add(feedback);
    }
}
