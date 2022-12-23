package Prompts;

// Database
import Database.AccountsDB;

// Helpers & Models
import Helpers.InputHelper;
import Models.Student;
import Models.Teacher;
import Models.User;

// Exceptions
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Controllers
import Controllers.AdminController;
import Controllers.StudentController;
import Controllers.TeacherController;

public class LoginSystem {
    private static final Scanner scan = new Scanner(System.in);
    // Access accounts database
    private static final AccountsDB accounts = AccountsDB.INSTANCE;
    // Load user accounts
    private static final List<User> users = accounts.getUsers();

    public static void prompt() {
        // Prompt initial welcome print screen
        System.out.println();
        System.out.println("======================================");
        System.out.println("|    Text-Based                      |");
        System.out.println("|      Learning Management System    |");
        System.out.println("======================================");

        while (true) {
            System.out.println("""

                    TB-LMS >>    Hello, welcome to the dashboard.
                                 What do you want to do?

                    1. Login.
                    2. Exit.
                    """);

            String input = scan.nextLine().trim();

            if (InputHelper.hasLetterInput(input))
                continue;

            int choice = Integer.parseInt(input);

            if (choice == 1)
                login();
            else if (choice == 2)
                return;
            else {
                System.out.println("""

                        =======================================
                        |        Error: Invalid input!        |
                        =======================================
                        """);
            }
        }
    }

    public static void login() {
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

                        =======================================
                        |       Error: Account not found.     |
                        =======================================
                        """);
                LoginSystem.prompt();
            }
        }
    }

    public static void loadAccounts() {
        try {
            accounts.hasAccounts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public class LoginSystemTest {

        // Declare the variables and objects
        private static Scanner scan;
        private static AccountsDB accounts;
        private static List<User> users;
        private static User account;
        private static String accountType;
        private static InputHelper inputHelper;
        private static AdminController adminController;
        private static StudentController studentController;
        private static TeacherController teacherController;
        private static String username;
        private static String password;

        // Initialize the variables and objects
        public void setUp() {
            scan = new Scanner(System.in);
            accounts = AccountsDB.INSTANCE;
            users = accounts.getUsers();
            account = null;
            accountType = "";
            inputHelper = new InputHelper();
            adminController = new AdminController(scan);
            studentController = new StudentController((Student) account);
            teacherController = new TeacherController((Teacher) account, scan);
            username = "";
            password = "";
        }

        // Execute the test
        public static void testLogin() {
            // Test 1 - Login with valid credentials
            username = "admin";
            password = "password";
            for (var user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    account = user;
                    accountType = account.getType();
                    break;
                }
            }
            switch (accountType) {
                case "admin" -> {
                    adminController.start();
                }
                case "student" -> {
                    studentController.start();
                }
                case "teacher" -> {
                    teacherController.start();
                }
                default -> {
                    System.out.println("""

                            =======================================
                            |       Error: Account not found.     |
                            =======================================
                            """);
                    LoginSystem.prompt();
                }
            }
            // Test 2 - Login with invalid credentials
            username = "invaliduser";
            password = "invalidpassword";
            for (var user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    account = user;
                    accountType = account.getType();
                    break;
                }
            }
            switch (accountType) {
                case "admin" -> {
                    adminController.start();
                }
                case "student" -> {
                    studentController.start();
                }
                case "teacher" -> {
                    teacherController.start();
                }
                default -> {
                    System.out.println("""

                            =======================================
                            |       Error: Account not found.     |
                            =======================================
                            """);
                    LoginSystem.prompt();
                }
            }
        }

        // Tear down the variables and objects
        public void tearDown() {
            scan = null;
            accounts = null;
            users = null;
            account = null;
            accountType = null;
            inputHelper = null;
            adminController = null;
            studentController = null;
            teacherController = null;
            username = null;
            password = null;
        }
    }

}
