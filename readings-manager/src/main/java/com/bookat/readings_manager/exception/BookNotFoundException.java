package com.bookat.readings_manager.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
  public BookNotFoundException(){super("There's no registered book with this id!");}


}
