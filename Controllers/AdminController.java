package Controllers;

// imports from Java
import java.util.List;
import java.util.Scanner;

// imports from package
import Database.AccountsDB;
import Helpers.InputHelper;
import Interfaces.AdminInterface;
import Models.User;

public class AdminController {
    private final AccountsDB accountsDB = AccountsDB.INSTANCE;
    private final List<User> accounts;
    private final AdminInterface adminInterface = new AdminInterface();

    private final Scanner scan;

    // Retrieve accounts from database
    public AdminController(Scanner scan) {
        this.scan = scan;
        accounts = accountsDB.getUsers();
    }

    // Function to start admin dashboard
    public void start() {
        chooseFromDashboard();
    }

    // Function to prompt admin dashboard
    private void chooseFromDashboard() {
        while (true) {
            adminInterface.showDashboard();
            String input = scan.nextLine().trim();

            if (InputHelper.hasLetterInput(input))
                continue;

            int choice = Integer.parseInt(input);

            // Prompt choices
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deleteAccount();
                case 3 -> adminInterface.listAccounts(accounts);
                case 4 -> {
                    return;
                }
            }
        }
    }

    // for account creation using admin account
    public void createAccount() {
        accountsDB.createAccount();
    }

    // for account deleting using admin account
    public void deleteAccount() {
        accountsDB.deleteAccount();
    }
}
