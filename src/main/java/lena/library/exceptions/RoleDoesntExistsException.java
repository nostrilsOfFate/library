package lena.library.exceptions;


public class RoleDoesntExistsException extends RuntimeException {

    public RoleDoesntExistsException(String message) {
        super("Role with name <" + message + "> doesn't exist.");
    }
}
