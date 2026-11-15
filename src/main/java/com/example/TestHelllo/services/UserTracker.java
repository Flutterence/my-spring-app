package com.example.TestHelllo.services;

import com.example.TestHelllo.events.UserActionEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserTracker {
    private final ApplicationEventPublisher publisher;

    public UserTracker(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void trackAction(int userId,String action,String metadata) {
        publisher.publishEvent(new UserActionEvent(this,userId,action,metadata));
    }
}
