package com.vzs.reactive.spring.reactor.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class FluxColdTest {

    @Test
    public void FluxTest() {
        List<Integer> elements = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
                .log()
//                .subscribeOn(Schedulers.parallel())
                .subscribe(elements::add);

        assertThat(elements).containsExactly(1, 2, 3, 4);
    }

//    @Test
    public void testCustomerSubscriber() {
        List<Integer> elements = new ArrayList<>();


        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription s;
                    int onNextAmount;

                    @Override
                    public void onSubscribe(Subscription s) {
//                        log.info("onSubscribe");
                        this.s = s;
                        s.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
//                        log.info("onNext");
                        elements.add(integer);
                        onNextAmount ++;
                        if (onNextAmount % 2 == 0) {
                            s.request(Long.MAX_VALUE);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {}

                    @Override
                    public void onComplete() {}
                });
        assertThat(elements).containsExactly(1, 2, 3, 4);
    }

//    @Test
    public void testZip() {
        List<String> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .zipWith(Flux.range(0, Integer.MAX_VALUE),
                        (one, two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
                .subscribe(elements::add);

        assertThat(elements).containsExactly(
                "First Flux: 2, Second Flux: 0",
                "First Flux: 4, Second Flux: 1",
                "First Flux: 6, Second Flux: 2",
                "First Flux: 8, Second Flux: 3");
    }

}
