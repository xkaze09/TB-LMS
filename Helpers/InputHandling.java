package Helpers;

public class InputHandling {
    public static boolean hasLetterInput(String input) {
        if (input.matches("[A-Za-z]*")) {
            System.out.println("""
                    Enter numbers only.
                    """);
            return true;
        }
        return false;
    }
}
