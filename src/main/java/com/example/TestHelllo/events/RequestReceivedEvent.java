package com.example.TestHelllo.events;

import org.springframework.context.ApplicationEvent;

public class RequestReceivedEvent extends ApplicationEvent {
    private final String method;
    private final String url;
    public RequestReceivedEvent(Object source, String method, String url) {
        super(source);
        this.method = method;
        this.url = url;
    }
    public String getMethod() {
        return method;
    }
    public String getUrl() {
        return url;
    }
}
