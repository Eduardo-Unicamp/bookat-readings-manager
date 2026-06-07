package com.bookat.readings_manager.exception;

public class ErrorDuringTokenGenerationException extends RuntimeException {
    public ErrorDuringTokenGenerationException(String message) {
        super(message);
    }
    public ErrorDuringTokenGenerationException() {
        super("Erro no processo de geração do token JWT");
    }

}
