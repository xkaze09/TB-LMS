import Prompts.UserSystem;

public class Main {
    public static void main(String[] args) {
        // Load system
        UserSystem.loadAccounts();
        // Prompt login/register
        UserSystem.prompt();
    }
}