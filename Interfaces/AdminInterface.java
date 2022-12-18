package Interfaces;

import Models.User;

import java.util.List;

public class AdminInterface {
    public void showDashboard() {
        System.out.println("""
                \nHello, admin. What do you want to do?

                1. Create account (Teacher or Student)
                2. Delete an existing account
                3. List all existing accounts
                4. Logout
                """);
    }

    public void listAccounts(List<User> accounts) {
        for (var user : accounts) {
            // skips the admin account
            if (user.getUsername().equals("admin"))
                continue;

            System.out.printf("""
                    \n============ Accounts List ============
                    Username: %s
                    Password: %s
                    \n=======================================
                    """, user.getUsername(), user.getPassword());
        }
    }
}
