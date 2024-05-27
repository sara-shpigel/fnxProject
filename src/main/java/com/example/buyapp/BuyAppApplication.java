package com.example.buyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BuyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyAppApplication.class, args);
    }

}
