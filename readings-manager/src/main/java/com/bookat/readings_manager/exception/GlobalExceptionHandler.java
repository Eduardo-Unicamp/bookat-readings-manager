package com.bookat.readings_manager.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ReadingNotFoundException.class)
    public ResponseEntity<String> ReadingNotFoundExceptionHandler(ReadingNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> UserNotFoundExceptionHandler(UserNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> BookNotFoundExceptionHandler(BookNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<String> GroupNotFoundExceptionHandler(GroupNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(EmptyRequiredFieldsException.class)
    public ResponseEntity<String> EmptyRequiredFieldsExceptionHandler(EmptyRequiredFieldsException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(PassingInvalidUserIdException.class)
    public ResponseEntity<String> PassingInvalidUserIdExceptionHandler(PassingInvalidUserIdException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> DataIntegrityViolationExceptionHandler(DataIntegrityViolationException e){
        if(e.getMessage() !=null && e.getMessage().contains("users_email_key")){
            //se for por causa do email repetido
            return ResponseEntity.status(409).body("O email informado já está em uso!");
        }
        //se for alguma outra coisa
        return ResponseEntity.status(400).body("Erro de violação de integridade de dados!");



    }
    @ExceptionHandler(FileUploadFailedException.class)
    public ResponseEntity<String> FileUploadFailedExceptionHandler(FileUploadFailedException e){
        return ResponseEntity.status(500).body(e.getMessage());
    }

}
