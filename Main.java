import Prompts.LoginSystem;

public class Main {
    public static void main(String[] args) {
        // Load system
        LoginSystem.loadAccounts();
        // Prompt login/register
        LoginSystem.prompt();
    }
}