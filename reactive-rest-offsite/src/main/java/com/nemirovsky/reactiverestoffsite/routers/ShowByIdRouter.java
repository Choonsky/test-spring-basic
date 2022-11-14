package com.nemirovsky.reactiverestoffsite.routers;

import com.nemirovsky.reactiverestoffsite.handlers.ShowByIdHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class ShowByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ShowByIdHandler showByIdHandler) {
        return RouterFunctions.route(GET("/{id}").and(accept(MediaType.APPLICATION_JSON)), showByIdHandler::showById);
    }
}
