package com.bookat.readings_manager.exception;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String message) {
        super(message);
    }
    public GroupNotFoundException(){super("The informed id does not corresponde to a group!");}

}
