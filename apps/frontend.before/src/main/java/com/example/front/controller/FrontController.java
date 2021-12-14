package com.example.front.controller;

import org.springframework.ui.Model;
import com.example.front.service.FrontService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Controller
public class FrontController {

    private final FrontService svc;

    @GetMapping("/")
    public String index(Model model) {
        Mono<String> message = svc.getData();
        model.addAttribute("message", message);
        return "index";
    }

}
