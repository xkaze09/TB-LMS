package Database;

import Helpers.FileHelper;
import Models.Admin;
import Models.Student;
import Models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountsDatabase {
    public static final AccountsDatabase INSTANCE = new AccountsDatabase();
    private final static File accountsCSV = new File("./Database/CSV/accounts.csv");
    private final List<User> users = new ArrayList<>();
    private final List<Student> studentList = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);

    private AccountsDatabase() {
        users.add(new Admin());
    }

    public void createAccount() {
        System.out.println("""
                            Create What type of account?
                            0. Student
                            1. Teacher
                """);

        int choice = Integer.parseInt(scan.nextLine());
        String type = (choice == 0) ? "student" : "teacher";

        System.out.print("What is your first name? ");
        String firstName = scan.nextLine();

        System.out.print("What is your last name? ");
        String lastName = scan.nextLine();

        System.out.print("What is your desired username: ");
        String username = scan.nextLine();

        System.out.print("What is your desired password? ");
        String password = scan.nextLine();

        System.out.print("What is your age? ");
        Integer age = Integer.parseInt(scan.nextLine());

        var newUser = new User.UserBuilder(firstName, lastName)
                .username(username)
                .password(password)
                .age(age)
                .build(type);

        if (type.equals("student")) {
            studentList.add((Student) newUser);
        }

        users.add(newUser);

        // appends the user's information to the accountsCSV
        String info = "%s,%s,%s,%s,%d,%s\n";

        FileHelper.writeToFile(accountsCSV, String.format(info, newUser.getFirstName(), newUser.getLastName(),
                newUser.getUsername(), newUser.getPassword(), newUser.getAge(), newUser.getType()));
    }

    public void deleteAccount() {
        // Delete accounts as admin, except admin
    }

    public void updateAccountsCSV(String username) {
        // Updates accounts in CSV
    }

    public void listAccounts() {
        for (var user : users) {
            // skips the admin
            if (user.getUsername().equals("admin"))
                continue;

            System.out.printf("""
                    \n================
                    Username: %s
                    Password: %s
                    ================
                    """, user.getUsername(), user.getPassword());
        }
    }

    // for loading of accounts from CSV
    public void hasAccounts() throws IOException {
        // check if the DIR is created
        if (new File("./Database/CSV").mkdir()) {
            if (accountsCSV.createNewFile())
                writeHeader(); // if the file was created, write the header
        }
        // else means the DIR is already existing
        // checks if the file can be created or already existing
        else {
            if (accountsCSV.createNewFile())
                writeHeader();
            else
                readAccounts();
        }
    }

    private void writeHeader() {
        FileHelper.writeToFile(accountsCSV, "FirstName,LastName,Username,Password,Age,Type\n");
    }

    private void readAccounts() {
        try (Scanner scanAccount = new Scanner(accountsCSV)) {
            String header = scanAccount.nextLine();

            while (scanAccount.hasNextLine()) {
                String line = scanAccount.nextLine();

                if (line == null)
                    return;
                String[] data = line.split(",");

                User user = new User.UserBuilder(data[0], data[1])
                        .username(data[2])
                        .password(data[3])
                        .age(Integer.valueOf(data[4]))
                        .build(data[5]);

                users.add(user);

                if (user.getType().equals("student")) {
                    studentList.add((Student) user);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<User> getUsers() {
        return users;
    }

}
