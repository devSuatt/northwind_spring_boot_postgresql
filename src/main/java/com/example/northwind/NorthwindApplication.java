package com.example.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class NorthwindApplication {

    public static void main(String[] args) {
        SpringApplication.run(NorthwindApplication.class, args);
    }

}
