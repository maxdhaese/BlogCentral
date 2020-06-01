package be.intecbrussel.exceptions;

public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException() {
        super("Author not found in the database.");
    }
}
