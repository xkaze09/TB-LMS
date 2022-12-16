package Prompts;

import Controllers.AdminController;
import Controllers.StudentController;
import Controllers.TeacherController;
import Database.AccountsDatabase;
import Helpers.InputHandling;
import Models.Student;
import Models.Teacher;
import Models.User;

// Exceptions
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserSystem {
    private static final Scanner scan = new Scanner(System.in);
    // Access accounts database
    private static final AccountsDatabase accounts = AccountsDatabase.INSTANCE;
    // Load user accounts
    private static final List<User> users = accounts.getUsers();

    public static void prompt() {
        // prompt initial welcome print screen
        System.out.println("Welcome to the Learning Management System!");
        while (true) {
            System.out.println("""
                    \nEnter a command:
                    1. Login
                    2. Exit the program
                    """);
            String input = scan.nextLine().trim();

            if (InputHandling.hasLetterInput(input))
                continue;

            int choice = Integer.parseInt(input);

            if (choice == 1)
                login();
            else if (choice == 2)
                return;
            else {
                System.out.println("""
                        Error: Invalid input!
                        """);
            }
        }
    }

    public static void login() {
        // ask for username
        // ask for password
        // check account from database
        // verify whether admin, student, or teacher, or invalid
        System.out.print("\nEnter your username: ");
        String username = scan.nextLine();
        System.out.print("Enter your password: ");
        String password = scan.nextLine();

        User account = null;
        String accountType = "";

        for (var user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                account = user;
                accountType = account.getType();
                break;
            }
        }
        switch (accountType) {
            case "admin" -> {
                var adminController = new AdminController(scan);
                adminController.start();
            }
            case "student" -> {
                var studentController = new StudentController((Student) account);
                studentController.start();
            }
            case "teacher" -> {
                var teacherController = new TeacherController((Teacher) account, scan);
                teacherController.start();
            }
            default -> {
                System.out.println("""
                        Error: Account does not exist.
                        """);
                UserSystem.prompt();
            }
        }
    }

    public static void loadAccounts() {
        // loading of accounts from CSV
        // reading CSV files without overwriting everytime the program is run
    }
}
