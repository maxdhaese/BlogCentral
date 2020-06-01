package be.intecbrussel.exceptions;

public class AuthorNotLoggedInException extends Exception {
    public AuthorNotLoggedInException() {
        super("User is not logged in, unable to retrieve logged in user");
    }
}
