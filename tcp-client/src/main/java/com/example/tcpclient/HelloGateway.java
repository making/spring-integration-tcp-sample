package com.example.tcpclient;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.concurrent.CompletableFuture;

@MessagingGateway(name = "hello", defaultRequestChannel = "integrationFlow.input")
public interface HelloGateway {

    @Gateway
    String hello(String payload);

    @Gateway
    CompletableFuture<String> helloAsync(String payload);
}
