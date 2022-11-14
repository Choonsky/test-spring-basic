package com.nemirovsky.reactiverestbaeldung;

import com.nemirovsky.reactiverestbaeldung.client.ShowByIdClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveRestBaeldungApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReactiveRestBaeldungApplication.class, args);
//        ShowByIdClient client = new ShowByIdClient();
        ShowByIdClient client = context.getBean(ShowByIdClient.class);

        client.consume();
    }

}
