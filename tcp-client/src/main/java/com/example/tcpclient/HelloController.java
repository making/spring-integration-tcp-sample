package com.example.tcpclient;

import org.springframework.integration.core.MessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final MessagingTemplate messagingTemplate;

    public HelloController(MessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping(path = "{name}")
    public String hello(@PathVariable("name") String name) {
        return this.messagingTemplate.convertSendAndReceive(name, String.class);
    }
}
