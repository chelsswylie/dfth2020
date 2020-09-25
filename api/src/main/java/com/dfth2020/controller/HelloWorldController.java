package com.dfth2020.controller;

import com.dfth2020.server.api.HelloApi;
import com.dfth2020.server.model.HelloWorld;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldController implements HelloApi {

    @Override
    public ResponseEntity<HelloWorld> helloWorldGet() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setHello("world");

        return ResponseEntity.ok(helloWorld);
    }
}
