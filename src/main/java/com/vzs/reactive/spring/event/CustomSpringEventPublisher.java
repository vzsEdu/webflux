package com.vzs.reactive.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomSpringEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishAnEvent(final String message) {
        log.info("Publishing custom event. ");
        AnotherCustomEvent customSpringEvent = new AnotherCustomEvent(new Object(), message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}