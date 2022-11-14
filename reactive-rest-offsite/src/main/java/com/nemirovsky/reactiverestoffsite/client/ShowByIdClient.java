package com.nemirovsky.reactiverestoffsite.client;

import com.nemirovsky.reactiverestoffsite.dto.SimpleResponce;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ShowByIdClient {

    private final WebClient client;

    public ShowByIdClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8082").build();
    }

    public Mono<String> getMessage() {
        return this.client.get().uri("/12345").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(SimpleResponce.class)
                .map(SimpleResponce::getMessage);
    }
}