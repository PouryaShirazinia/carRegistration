package com.avizhe.carregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CarRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRegistrationApplication.class, args);
    }

}
