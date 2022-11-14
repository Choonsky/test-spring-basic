package com.nemirovsky.reactiverestoffsite.handlers;

import com.nemirovsky.reactiverestoffsite.dto.SimpleResponce;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ShowByIdHandler {

    private static final String TEST_MESSAGE = "TEST MESSAGE";

    public Mono<ServerResponse> showById(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new SimpleResponce(request.pathVariable("id"), TEST_MESSAGE)));
    }
}
