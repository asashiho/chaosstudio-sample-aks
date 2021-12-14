package com.example.front.api;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class FrontApi {

    private WebClient webClient = WebClient.builder().build();
    
    public Mono<String> getApiData() {
        return webClient.get()
                .uri("http://backend:8081/message")
                .retrieve()
                .bodyToMono(String.class);
    }
}
