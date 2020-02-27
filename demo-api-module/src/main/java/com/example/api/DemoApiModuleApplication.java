package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.common")
@EnableJpaRepositories("com.example.common")
@SpringBootApplication
public class DemoApiModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiModuleApplication.class, args);
    }

}
