package com.example.sqch10ex6.service;

import com.example.sqch10ex6.exception.NotEnoughMoneyException;
import com.example.sqch10ex6.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
