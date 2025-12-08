package com.example.sqch10ex7.controllerAdvice;

import com.example.sqch10ex7.exception.NotEnoughMoneyException;
import com.example.sqch10ex7.model.ErrorDetails;
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
