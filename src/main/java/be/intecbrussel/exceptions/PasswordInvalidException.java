package be.intecbrussel.exceptions;

public class PasswordInvalidException extends Exception{
    public PasswordInvalidException() {
        super("Invalid password");
    }
}
