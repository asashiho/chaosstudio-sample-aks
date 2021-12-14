package com.example.front.service;

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

    public Mono<String> getData() {
        return api.getApiData();
    }
}
