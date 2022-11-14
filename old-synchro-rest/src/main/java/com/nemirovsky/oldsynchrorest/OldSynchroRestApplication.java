package com.nemirovsky.oldsynchrorest;

import com.nemirovsky.oldsynchrorest.models.SimpleResponce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@RestController
public class OldSynchroRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldSynchroRestApplication.class, args);
    }

    @GetMapping("/{id}")
    public SimpleResponce showById(@PathVariable String id,
                                   @RequestParam(value = "message", defaultValue = "EMPTY") String message,
                                   @RequestParam(required = false, name="add1") String add1,
                                   @RequestParam Optional<String> add2) {
        return new SimpleResponce(id, message + add1 + add2.get());
    }

}
