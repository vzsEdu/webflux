package com.vzs.reactive.spring.reactor.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RunWith(MockitoJUnitRunner.class)
public class FluxHotTest {
    @Test
    public void infiniteTest() {
        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while(true) {
                fluxSink.next(System.currentTimeMillis());
            }
        })
                .sample(Duration.ofSeconds(2))
                .publish();

        publish.subscribe(System.out::println);

//        publish.connect();
    }
}
