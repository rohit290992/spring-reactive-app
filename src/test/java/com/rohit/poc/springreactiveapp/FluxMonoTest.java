package com.rohit.poc.springreactiveapp;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxMonoTest {
    @Test
    public void fluxTest() {
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
                .concatWith(Flux.just("After Error"))
                .log();
        stringFlux.subscribe(System.out::println,
                (e) -> System.err.println("why not printed this line" + e),
                () -> System.out.println("Completed"));
    }

    @Test
    public void monoTest() {
        Mono<String> stringMono = Mono.just("Spring").log();
        stringMono.subscribe(System.out::println,
                (e) -> System.err.println("Exception is " + e),
                () -> System.out.println("Completed"));
    }
}
