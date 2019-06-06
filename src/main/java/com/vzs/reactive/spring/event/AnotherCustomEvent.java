package com.vzs.reactive.spring.event;

import org.springframework.context.ApplicationEvent;

public class AnotherCustomEvent extends ApplicationEvent {
    private String message;

    public AnotherCustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
