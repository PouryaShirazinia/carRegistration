package com.mahan.carregistration.exeption;


import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ResourceBundle;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(ServiceException serviceException) {


        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage(getMessage(serviceException.getErrorCode()));

        return ResponseEntity.badRequest().body(exceptionResponse);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(MethodArgumentNotValidException exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        FieldError fieldError = exception.getBindingResult().getFieldError();
        exceptionResponse.setMessage(getMessage(fieldError.getDefaultMessage()));

        return ResponseEntity.badRequest().body(exceptionResponse);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(ConstraintViolationException exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage(getMessage(exception.getConstraintViolations().iterator().next().getMessage()));

        return ResponseEntity.badRequest().body(exceptionResponse);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(Exception exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage(exception.getMessage());

        return ResponseEntity.unprocessableEntity().body(exceptionResponse);

    }


    private String getMessage(String key) {
        try {
            return ResourceBundle.getBundle("message/message")
                    .getString(key);
        } catch (Exception e) {
            return key;
        }
    }

}
