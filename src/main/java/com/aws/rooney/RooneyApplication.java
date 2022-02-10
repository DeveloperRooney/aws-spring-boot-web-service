package com.aws.rooney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RooneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RooneyApplication.class, args);
    }

}
