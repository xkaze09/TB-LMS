
// imports from package
import Prompts.LoginSystem;
import Prompts.LoginSystem.LoginSystemTest;

public class Main {
    public static void main(String[] args) {
        // Load system
        LoginSystem.loadAccounts();
        // Prompt login/register
        LoginSystem.prompt();
        // LoginSystemTest.testLogin(); for test case #1
    }
}