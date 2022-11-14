package com.nemirovsky.reactiverestoffsite;

import com.nemirovsky.reactiverestoffsite.client.ShowByIdClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveRestOffsiteApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReactiveRestOffsiteApplication.class, args);
        ShowByIdClient showByIdClient = context.getBean(ShowByIdClient.class);
        // We need to block for the content here or the JVM might exit before the message is logged
        System.out.println(">> message = " + showByIdClient.getMessage().block());
    }

}
