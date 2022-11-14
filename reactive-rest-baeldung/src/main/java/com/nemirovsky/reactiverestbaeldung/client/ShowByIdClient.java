package com.nemirovsky.reactiverestbaeldung.client;

import com.nemirovsky.reactiverestbaeldung.models.SimpleResponce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Slf4j
@Component
public class ShowByIdClient {

// Not working somehow, look later, will use environment instead
//    @Value("${server.port}")
//    private String serverPort;

    // Why not simply annotate with @Slf4J?
    //    private static final Logger LOGGER = LoggerFactory.getLogger(ShowByIdClient.class);

    private final Environment env;

    private final WebClient client;


//    WebClient client = WebClient.create("http://localhost:" + "8082");

    public ShowByIdClient(WebClient.Builder builder, Environment env) {
        this.env = env; // not-so-beautiful workaround initializing environment
        this.client = builder.baseUrl("http://localhost:" + env.getProperty("server.port")).build();
    }
    public void consume() {

        Mono<SimpleResponce> responceMono = client.get()
                .uri("/{id}", "12345")
                .retrieve()
                .bodyToMono(SimpleResponce.class);

        responceMono.subscribe(System.out::println);
//        SimpleResponce res = responceMono.block(Duration.of(10000, ChronoUnit.MILLIS));
//        log.info("For id = {} got message {}", res.getId(), res.getMessage());
    }

}
