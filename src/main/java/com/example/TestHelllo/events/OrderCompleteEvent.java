package com.example.TestHelllo.events;

import org.springframework.context.ApplicationEvent;

public class OrderCompleteEvent extends ApplicationEvent {
    private final int orderId;
    private final int summ;

    public OrderCompleteEvent(Object source,int orderId,int summ) {
        super(source);
        this.orderId = orderId;
        this.summ = summ;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSumm() {
        return summ;
    }
}
