package com.vzs.reactive.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AnnotationDrivenContextStartedListener {

    @EventListener
    public void test(AnotherCustomEvent anotherCustomEvent) {
        log.info("I am in annotation event {}", anotherCustomEvent.getMessage());
    }
}
