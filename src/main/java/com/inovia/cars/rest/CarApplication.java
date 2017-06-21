package com.inovia.cars.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot Initialization class
 *
 * @author himanshu.kapoor
 */
@Configuration
@ComponentScan(basePackages = {"com.inovia.cars.rest"})
@EnableAutoConfiguration
public class CarApplication {

    /**
     * Hook to start the Spring boot application
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }
}
