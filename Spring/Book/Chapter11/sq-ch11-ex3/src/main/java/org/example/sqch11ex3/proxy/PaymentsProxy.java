package org.example.sqch11ex3.proxy;

import org.example.sqch11ex3.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {

    private final WebClient webClient;

    @Value("${name.service.url}")
    private String nameServiceUrl;

    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(String requestID, Payment payment) {
        return webClient.post()
                .uri(nameServiceUrl + "/payments")
                .header("requestID",requestID)
                .body(Mono.just(payment),Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);
    }
}
