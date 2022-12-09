package Controllers;

import Database.AccountsDatabase;
import Helpers.FileHelper;
import Helpers.InputHandling;
import Models.Student;
import Models.Teacher;
import Interfaces.TeacherInterface;

import java.util.List;
import java.util.Scanner;

public class TeacherController {
    private final Teacher teacher;
    private final TeacherInterface teacherView = new TeacherInterface();
    private final AccountsDatabase accountsDB = AccountsDatabase.INSTANCE;
    private final Scanner scan;

    public TeacherController(Teacher teacher, Scanner scan) {
        this.teacher = teacher;
        this.scan = scan;
        // retrieve given feedbacks
        // retrieve given assignments
    }

    public void start() {
        chooseFromDashboard();
    }

    private void chooseFromDashboard() {
        while (true) {

            teacherView.showMyDashboard();
            String input = scan.nextLine();

            if (InputHandling.hasLetterInput(input))
                continue;

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1 -> giveFeedback();
                case 2 -> giveAssignment();
                case 3 -> clearAssignments();
                case 4 -> clearFeedback();
                case 5 -> giveFeedback(); // must be see self info
                case 6 -> giveFeedback(); // must be see given feedbacks
                case 7 -> giveFeedback(); // must be see given assignments
                case 8 -> {
                    return;
                }
            }
        }
    }

    public void giveFeedback() {

    }

    public void giveAssignment() {

    }

    public void clearFeedback() {

    }

    public void clearAssignments() {

    }
}
