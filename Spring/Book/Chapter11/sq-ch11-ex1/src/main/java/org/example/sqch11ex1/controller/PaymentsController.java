package org.example.sqch11ex1.controller;

import org.example.sqch11ex1.model.Payment;
import org.example.sqch11ex1.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payments")
    public Payment createPayment(@RequestBody Payment payment) {
        String requestID = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestID, payment);
    }
}
