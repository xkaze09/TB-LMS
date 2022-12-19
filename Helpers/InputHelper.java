package Helpers;

public class InputHelper {
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
