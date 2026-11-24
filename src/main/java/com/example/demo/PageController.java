package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "This is the main page";
    }

    @GetMapping("/contact")
    public String contact() {
        return "This is the contact page";
    }
}
