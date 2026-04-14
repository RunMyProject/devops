package com.example.demo; // Cambia il package in quello principale

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello") // Aggiungi la "l" mancante
    public String hello() {
        return "Hello World";
    }
}
