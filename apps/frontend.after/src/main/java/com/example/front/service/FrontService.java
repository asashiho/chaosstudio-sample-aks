package com.example.front.service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import com.example.front.api.FrontApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class FrontService {

    private final FrontApi api;
    private final CircuitBreakerRegistry circuitBreakerRegistry;

    public Mono<String> getData() {
        CircuitBreaker circuit = circuitBreakerRegistry.circuitBreaker("frontbreaker");

        return api.getApiData()
                .transform(CircuitBreakerOperator.of(circuit))
                .onErrorResume(this::fallback);
    }

    public Mono<String> fallback(Throwable t) {
        log.error("Fallback : " + t.getMessage());
        return Mono.just("Sorry...I'm frontend.");
    }
}
