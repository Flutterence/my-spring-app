package com.example.TestHelllo.events;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserActionEvent extends ApplicationEvent {

    private final int userId;
    private final String action;
    private final LocalDateTime timestamp;
    private final String metadata;
    private final String id;
    public UserActionEvent(Object source,int userId, String action, String metadata) {
        super(source);
        this.userId = userId;
        this.action = action;
        this.timestamp = LocalDateTime.now();
        this.metadata = metadata;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }

    public String getMetadata() {
        return metadata;
    }
    public LocalDateTime getTime() {
        return timestamp;
    }
}
