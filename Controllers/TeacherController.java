package Controllers;

import Database.AccountsDB;
import Helpers.FileHelper;
import Helpers.InputHelper;
import Helpers.ListHelper;
import Interfaces.TeacherInterface;
import Models.Feedback;
import Models.Student;
import Models.Assignments;
import Models.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherController {

    private static List<Feedback> givenFeeds;
    private static List<Assignments> givenAssignments;
    private final Teacher teacher;
    private final TeacherInterface teacherInterface = new TeacherInterface();
    private final AccountsDB accountsDB = AccountsDB.INSTANCE;
    private final List<Student> studentList = accountsDB.getStudentList();
    private final Scanner scan;

    public TeacherController(Teacher teacher, Scanner scan) {
        this.teacher = teacher;
        this.scan = scan;
        // retrieve given feedbacks
        givenFeeds = teacher.getGivenFeedbacks();
        // retrieve given assignments
        givenAssignments = teacher.getGivenAssignments();
    }

    // Function to start teacher dashboard
    public void start() {
        chooseFromDashboard();
    }

    // Function to prompt teacher dashboard
    private void chooseFromDashboard() {
        while (true) {

            teacherInterface.showMyDashboard();
            String input = scan.nextLine();

            if (InputHelper.hasLetterInput(input))
                continue;

            int choice = Integer.parseInt(input);

            // Prompt choices
            switch (choice) {
                case 1 -> giveFeedback();
                case 2 -> giveAssignment();
                case 3 -> clearAssignments();
                case 4 -> clearFeedbacks();
                case 5 -> teacherInterface.viewMyInfo(teacher); // must be see self info
                case 6 -> teacherInterface.viewGivenFeedbacks(givenFeeds); // must be see given feedbacks
                case 7 -> teacherInterface.viewGivenAssignments(givenAssignments); // must be see given assignments
                case 8 -> {
                    return;
                }
            }
        }
    }

    public void giveFeedback() {
        Student student;
        int i = 0;

        if (!ListHelper.hasStudents(studentList, "feeds"))
            return;

        System.out.println("\nEnter the student number: ");

        for (var user : studentList) {
            System.out.println(i + ": " + user.getFirstName());
            i++;
        }

        int studentNumber = Integer.parseInt(scan.nextLine());

        student = studentList.get(studentNumber);

        System.out.print("Enter your feedback: ");
        String feed = scan.nextLine();

        Feedback feedback = new Feedback(student.getFirstName(), teacher.getFirstName(), feed);
        givenFeeds.add(feedback);

        // accepts the feed for the student obj to also have a reference to the feedback
        student.getMyController().acceptFeedback(feedback);

        FileHelper.writeToFile(teacher.getFeedbacksCSV(), feedback + "\n");
    }

    public void giveAssignment() {
        Student student;
        int i = 0;

        if (!ListHelper.hasStudents(studentList, "assignments"))
            return;

        System.out.println("\nEnter the student number");

        for (var user : studentList) {
            System.out.println(i + ": " + user.getFirstName());
            i++;
        }

        System.out.print(": ");
        int studentNumber = Integer.parseInt(scan.nextLine());

        student = studentList.get(studentNumber);

        System.out.print("Enter the assignment: ");
        String givenTask = scan.nextLine();

        Assignments assignment = new Assignments(student.getFirstName(), teacher.getFirstName(), givenTask);
        givenAssignments.add(assignment);
        student.getMyController().acceptAssignment(assignment); // accepts the assignment for the student obj to also
                                                                // have a reference to
        // the assignment

        FileHelper.writeToFile(teacher.getAssignmentsCSV(), assignment + "\n");
    }

    public void clearFeedbacks() {
        System.out.println("""

                ========================================
                |   Successfully cleared all feedback  |
                ========================================
                """);

        givenFeeds.clear();
        FileHelper.clearFile(teacher.getFeedbacksCSV(), "StudentName,TeacherName,Feedback\n");
    }

    public void clearAssignments() {
        System.out.println("""

                ========================================
                | Successfully cleared all assignments |
                ========================================
                """);

        givenAssignments.clear();
        FileHelper.clearFile(teacher.getAssignmentsCSV(), "StudentName,TeacherName,Assignment\n");
    }
}
