package Exceptions;

// This class creates an exception for an invalid account type.
public class InvalidAccountTypeException extends RuntimeException {
    public InvalidAccountTypeException(String message) {
        super(message);
    }
}
