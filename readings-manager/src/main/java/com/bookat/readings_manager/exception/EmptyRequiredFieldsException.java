package com.bookat.readings_manager.exception;

public class EmptyRequiredFieldsException extends RuntimeException {
  public EmptyRequiredFieldsException(String message) {
    super(message);
  }
  public EmptyRequiredFieldsException(){
      super("Some of the required fields are empty");
  }


}
