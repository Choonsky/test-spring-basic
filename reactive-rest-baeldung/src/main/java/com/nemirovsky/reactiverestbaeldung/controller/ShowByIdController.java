package com.nemirovsky.reactiverestbaeldung.controller;

import com.nemirovsky.reactiverestbaeldung.models.SimpleResponce;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping
public class ShowByIdController {

//    @GetMapping
//    private Flux<SimpleResponce> showAll() {
//        return productRepository.findAllProducts();
//    }

    @GetMapping("/{id}")
    private Mono<SimpleResponce> showById(@PathVariable String id,
                                                 @RequestParam(value = "message", defaultValue = "EMPTY") String message,
                                                 @RequestParam(required = false, name="add1") String add1,
                                                 @RequestParam Optional<String> add2) {
        return Mono.just(new SimpleResponce(id, message + add1 + add2.get()));
        // return employeeRepository.findEmployeeById(id);
    }
}
