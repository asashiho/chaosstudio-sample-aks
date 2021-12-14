package com.example.back;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackController {

    @GetMapping("/message")
    String getmessage() {
            return "Hello, I'm backend!";
    }

}