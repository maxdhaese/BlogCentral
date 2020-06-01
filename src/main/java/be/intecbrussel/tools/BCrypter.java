package be.intecbrussel.tools;

import org.springframework.security.crypto.bcrypt.BCrypt;

// Password cannot be stored in the database as plain text. If the database is compromised, the hacker has all the
// passwords of all the users. Therefor we stored a salted hashed password instead. BCrypt is designed to be a slow
// hashing algorithm, therefor it is pretty efficient to greatly limit the damage done would our database be compromised.
// BCrypt also doesnt require us to store the salt in our database, which adds another layer of convenience and security?
public class BCrypter {
    public static String hashPassword(String password){
        // This method applies salted hashing to a password using the BCrypt algorithm
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainTextPassword, String hashToCompare) {
        // This method return whether the entered password corresponds to the entered hash value.
        return BCrypt.checkpw(plainTextPassword, hashToCompare);
    }
}
