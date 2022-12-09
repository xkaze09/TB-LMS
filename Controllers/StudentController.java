package Controllers;

import Models.Student;
import Interfaces.StudentInterface;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final Student student;
    private final StudentInterface studentView = new StudentInterface();

    private final Scanner scan = new Scanner(System.in);

    public StudentController(Student student) {
        this.student = student;

        student.setMyController(this);
    }

    public void start() {
        chooseFromDashboard();
    }

    private void chooseFromDashboard() {
        // mark an assignment as done
    }
}
