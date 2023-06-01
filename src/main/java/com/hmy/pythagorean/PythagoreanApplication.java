package com.hmy.pythagorean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PythagoreanApplication {

    public static void main(String[] args) {

        SpringApplication.run(PythagoreanApplication.class, args);

    }

}
