package Interfaces;

import java.util.List;

import Models.User;

public class AdminInterface {
    // Displays the dashboard menu for the admin user.
    public void showDashboard() {
        System.out.println("""

                TB-LMS >>   Hello, admin. What do you want to do?

                1. Create account (Teacher or Student)
                2. Delete an existing account
                3. List all existing accounts
                4. Logout
                """);
    }

    // Lists all existing accounts in the system, excluding the admin user.
    public void listAccounts(List<User> accounts) {
        int totalAccounts = 1;
        for (var user : accounts) {
            // skips the admin
            if (user.getUsername().equals("admin"))
                continue;

            System.out.printf("""

                    ========= %s =========
                    Username: %s
                    Password: %s
                    Account Type: %s
                    =====================
                    """, totalAccounts++, user.getUsername(), user.getPassword(), user.getType());
        }
        totalAccounts--; // To exclude exclusive index
        System.out.println("\n\nTotal accounts: " + totalAccounts);
    }
}
