package com.example.TestHelllo.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.annotation.Order;

public class OrderStartEvent extends ApplicationEvent {
    private final int orderId;

    public OrderStartEvent(Object source,int orderId) {
        super(source);
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}
