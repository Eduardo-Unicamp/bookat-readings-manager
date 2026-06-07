package com.bookat.readings_manager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(){super("A user with this id does not exist in the database");}

}
