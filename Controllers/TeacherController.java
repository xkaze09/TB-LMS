package Controllers;

import Database.AccountsDatabase;
import Helpers.FileHelper;
import Helpers.InputHandling;
import Helpers.ListHelper;
import Models.Student;
import Models.Assignment;
import Models.Feedback;
import Models.Teacher;
import Interfaces.TeacherInterface;

import java.util.List;
import java.util.Scanner;

public class TeacherController {
    private static List<Feedback> givenFeedbacks;
    private static List<Assignment> givenAssignments;
    private final Teacher teacher;
    private final TeacherInterface teacherInterface = new TeacherInterface();
    private final AccountsDatabase accountsDB = AccountsDatabase.INSTANCE;
    private final List<Student> studentList = accountsDB.getStudentList();
    private final Scanner scan;

    public TeacherController(Teacher teacher, Scanner scan) {
        this.teacher = teacher;
        this.scan = scan;
        // retrieve given feedbacks
        givenFeedbacks = teacher.getGivenFeedbacks();
        // retrieve given assignments
        givenAssignments = teacher.getGivenAssignments();

    }

    public void start() {
        chooseFromDashboard();
    }

    private void chooseFromDashboard() {
        while (true) {

            teacherInterface.showMyDashboard();
            String input = scan.nextLine();

            if (InputHandling.hasLetterInput(input))
                continue;

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1 -> giveFeedback();
                case 2 -> giveAssignment();
                case 3 -> clearAssignments();
                case 4 -> clearFeedback();
                case 5 -> teacherInterface.viewSelfInfo(teacher); // must be see self info
                case 6 -> teacherInterface.viewGivenFeedbacks(givenFeedbacks); // must be see given feedbacks
                case 7 -> teacherInterface.viewGivenAssignments(givenAssignments); // must be see given assignments
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
