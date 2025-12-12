package com.example.sqch10ex6.controllerAdvice;

import com.example.sqch10ex6.exception.NotEnoughMoneyException;
import com.example.sqch10ex6.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<?> exceptionNotEnoughMoneyExceptionHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to make the payment.");
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
