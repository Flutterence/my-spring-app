package com.example.TestHelllo.services;

import com.example.TestHelllo.events.OrderCompleteEvent;
import com.example.TestHelllo.events.OrderProccessEvent;
import com.example.TestHelllo.events.OrderStartEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OrderHandler {
    private final ApplicationEventPublisher publisher;
    public OrderHandler(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
    @Async
    public void processOrder(int orderId) throws InterruptedException {
        Random rand = new Random();
        publisher.publishEvent(new OrderStartEvent(this,orderId));
        Thread.sleep(2000);
        publisher.publishEvent(new OrderProccessEvent(this,orderId));
        Thread.sleep(2000);
        publisher.publishEvent(new OrderCompleteEvent(this,orderId, rand.nextInt(100,1000)));
    }
}
