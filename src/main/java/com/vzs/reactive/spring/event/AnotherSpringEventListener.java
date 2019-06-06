package com.vzs.reactive.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AnotherSpringEventListener implements ApplicationListener<AnotherCustomEvent> {
    @Override
    public void onApplicationEvent(AnotherCustomEvent event) {
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("AnotherSpringEventListener Received spring custom event - " + event.getMessage());
    }
}