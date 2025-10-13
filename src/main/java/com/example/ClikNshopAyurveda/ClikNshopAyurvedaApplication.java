package com.example.ClikNshopAyurveda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class ClikNshopAyurvedaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClikNshopAyurvedaApplication.class, args);
    }
}
