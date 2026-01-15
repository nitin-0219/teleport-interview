package com.smartload.optimizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCaching
public class SmartLoadApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartLoadApplication.class, args);
    }
}
