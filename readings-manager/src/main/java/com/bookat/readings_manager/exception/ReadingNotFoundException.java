package com.bookat.readings_manager.exception;

public class ReadingNotFoundException extends RuntimeException {
    public ReadingNotFoundException(String message) {
        super(message);
    }
    public ReadingNotFoundException(){super("A reading with this id does not exist in the database");}
}
