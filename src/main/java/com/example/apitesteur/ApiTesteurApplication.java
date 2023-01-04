package com.example.apitesteur;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class ApiTesteurApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTesteurApplication.class, args);
    }

}
