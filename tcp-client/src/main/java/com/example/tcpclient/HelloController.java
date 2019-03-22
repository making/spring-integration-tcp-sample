package com.example.tcpclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloGateway helloGateway;

    public HelloController(HelloGateway helloGateway) {
        this.helloGateway = helloGateway;
    }

    @GetMapping(path = "{name}")
    public String hello(@PathVariable("name") String name) {
        return this.helloGateway.hello(name);
    }
}
