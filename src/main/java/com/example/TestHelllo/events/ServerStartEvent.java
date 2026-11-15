package com.example.TestHelllo.events;

import org.springframework.context.ApplicationEvent;

public class ServerStartEvent extends ApplicationEvent {
    private final int port;
    public ServerStartEvent(Object source, int port) {
        super(source);
        this.port = port;
    }
    public int getPort() {
        return port;
    }

}
