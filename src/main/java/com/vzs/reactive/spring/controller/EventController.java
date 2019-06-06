package com.vzs.reactive.spring.controller;

import com.vzs.reactive.spring.event.CustomSpringEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring/event")
public class EventController {
    @Autowired
    private CustomSpringEventPublisher customSpringEventPublisher;

    @GetMapping("/publish/test")
    public String publish(@RequestParam String message) {
        customSpringEventPublisher.doStuffAndPublishAnEvent(message);
        return "Published";
    }

}
