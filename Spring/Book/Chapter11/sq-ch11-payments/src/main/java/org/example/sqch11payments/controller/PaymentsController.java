package org.example.sqch11payments.controller;


import org.example.sqch11payments.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {

    private static Logger log = Logger.getLogger(PaymentsController.class.getName());

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment) {
        log.info("Received request with id " + requestId + "; Payment Amount: " + payment.getAmount());

        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity.status(HttpStatus.OK)
                .header("requestID",requestId)
                .body(payment);
    }
}
