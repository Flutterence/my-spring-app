package com.example.TestHelllo.events;

import org.springframework.context.ApplicationEvent;

public class OrderProccessEvent extends ApplicationEvent {
    private final int orderId;

    public OrderProccessEvent(Object source,int orderId) {
        super(source);
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}
