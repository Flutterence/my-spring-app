package com.example.TestHelllo.controllers;

import com.example.TestHelllo.events.RequestReceivedEvent;
import com.example.TestHelllo.events.ServerStartEvent;
import com.example.TestHelllo.events.ServerStopEvent;
import com.example.TestHelllo.services.OrderHandler;
import com.example.TestHelllo.services.UserTracker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@RestController
public class ServerController {
    private final ApplicationEventPublisher publisher;
    private final OrderHandler orderHandler;
    private final UserTracker userTracker;

    public ServerController(ApplicationEventPublisher publisher, OrderHandler orderHandler, UserTracker userTracker) {
        this.publisher = publisher;
        this.orderHandler = orderHandler;
        this.userTracker = userTracker;
    }

    public void start(int port) {
        publisher.publishEvent(new ServerStartEvent(this, port));
    }

    @PreDestroy
    public void stop() {
        publisher.publishEvent(new ServerStopEvent(this));
    }

    @GetMapping("/hello")
    public String hello() {
        publisher.publishEvent(new RequestReceivedEvent(this, "GET", "/hello"));
        return "Hello from Event-Driven Server!";
    }
    @GetMapping("/order/{orderId}")
    public void order(@PathVariable int orderId) throws InterruptedException {
        orderHandler.processOrder(orderId);
    }
    /*В java нет такого цикла событий как в node.js поэтому порядок псевдокода ниже
    будет менятся
     */
    @GetMapping("/pcevdo-eventloop")
    public void runloop() {

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1. setTimeout");
        }).start();

        Executors.newSingleThreadExecutor().execute(() -> {
            System.out.println("2. setImmediate");
        });

        CompletableFuture.runAsync(() -> {
            System.out.println("3. process.nextTick");
        });

        CompletableFuture.runAsync(() -> {
            System.out.println("4. Promise.then");
        });

        System.out.println("5. Синхронный код");


    }

    @GetMapping("/usertracker/{userId}/{action}/{metadata}")
    public void usertracker(@PathVariable int userId,@PathVariable String action,@PathVariable String metadata) {
        userTracker.trackAction(userId,action,metadata);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ServerReady() {
        start(8080);
    }

}
