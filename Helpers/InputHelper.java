package Helpers;

public class InputHelper {
    // checks if the given input string contains any letter characters from A-Z or
    // a-z and returns a boolean value accordingly. If the input string contains
    // letter characters, it will also print a prompt message.
    public static boolean hasLetterInput(String input) {
        if (input.matches("[A-Za-z]*")) {
            System.out.println("""

                    =======================================
                    |      Please enter numbers only.     |
                    =======================================
                    """);
            return true;
        }
        return false;
    }
}
