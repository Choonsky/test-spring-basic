package com.nemirovsky.reactiverestoffsite;

import com.nemirovsky.reactiverestoffsite.dto.SimpleResponce;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SpringExtension.class) -- already in @SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShowByIdRouterRouterTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testShowById() {
        webTestClient
                // Create a GET request to test an endpoint
                .get().uri("/54321")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                // and use the dedicated DSL to test assertions against the response
                .expectStatus().isOk()
                .expectBody(SimpleResponce.class).value(greeting -> {
                    assertThat(greeting.getMessage()).isEqualTo("TEST MESSAGE");
                });
    }
}
