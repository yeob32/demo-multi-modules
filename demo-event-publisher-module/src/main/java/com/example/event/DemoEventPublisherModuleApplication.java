package com.example.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.common")
@EnableJpaRepositories("com.example.common")
@SpringBootApplication
public class DemoEventPublisherModuleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(DemoEventPublisherModuleApplication.class, args);
        cac.addApplicationListener((ApplicationListener<MyEvent>) event -> System.out.println("Hello spring boot onMyEvent" + event.getMessage()));
        cac.publishEvent(new MyEvent(cac, "Hello publish event !!"));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println("Hello ApplicationReadyEvent !!");
    }

    static class MyEvent extends ApplicationEvent {

        private final String message;

        public MyEvent(Object source, String message) {
            super(source);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
