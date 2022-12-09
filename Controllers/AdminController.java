package Controllers;

import Database.AccountsDatabase;
import Helpers.InputHandling;
import Models.User;
import Interfaces.AdminInterface;

import java.util.List;
import java.util.Scanner;

public class AdminController {
    private final AccountsDatabase accountsDB = AccountsDatabase.INSTANCE;
    private final List<User> accounts;
    private final AdminInterface adminView = new AdminInterface();

    private final Scanner scan;

    public AdminController(Scanner scan) {
        this.scan = scan;
        accounts = accountsDB.getUsers();
    }

    public void start() {
        chooseFromDashboard();
    }

    private void chooseFromDashboard() {
        while (true) {
            adminView.showDashboard();
            String input = scan.nextLine().trim();

            if (InputHandling.hasLetterInput(input))
                continue;

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deleteAccount();
                case 3 -> adminView.listAccounts(accounts);
                case 4 -> {
                    return;
                }
            }
        }
    }

    public void createAccount() {
        accountsDB.createAccount();
    }

    public void deleteAccount() {
        accountsDB.deleteAccount();
    }
}
