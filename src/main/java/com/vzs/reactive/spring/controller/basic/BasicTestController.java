package com.vzs.reactive.spring.controller.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/basic")
public class BasicTestController {
    @GetMapping("/flux")
    public Flux<String> fluxTest() {
        return Flux.just("1", "2", "3");
    }
}
