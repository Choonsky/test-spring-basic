package com.nemirovsky.reactiverestoffsite.client;

import com.nemirovsky.reactiverestoffsite.dto.SimpleResponce;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ShowByIdClient {

    private final WebClient client;

// Not working somehow, look later, will use environment instead
//    @Value("${server.port}")
//    private String serverPort;

    private final Environment env;

    public ShowByIdClient(WebClient.Builder builder, Environment env) {
        this.env = env; // not-so-beautiful workaround initializing environment
        this.client = builder.baseUrl("http://localhost:" + env.getProperty("server.port")).build();
    }

    public Mono<String> getMessage() {
        return this.client.get().uri("/12345").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(SimpleResponce.class)
                .map(SimpleResponce::getMessage);
    }
}