package com.example.TestHelllo.events;

import org.springframework.context.ApplicationEvent;

public class ServerStopEvent extends ApplicationEvent {
    public ServerStopEvent(Object source) {
        super(source);
    }
}
