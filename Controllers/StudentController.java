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
        // mark an assignment as done
    }
}
