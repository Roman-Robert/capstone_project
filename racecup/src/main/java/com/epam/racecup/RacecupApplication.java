package com.epam.racecup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RacecupApplication {

    public static void main(String[] args) {
        SpringApplication.run(RacecupApplication.class, args);
    }

}
