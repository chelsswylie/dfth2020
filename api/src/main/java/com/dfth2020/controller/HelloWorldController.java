package com.dfth2020.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello/world")
    public ResponseEntity<String> helloWorldGet() {
        return ResponseEntity.ok("hello world");
    }
}
