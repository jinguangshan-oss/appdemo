package com.example.appdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan(value = "com.example.appdemo.mybatis.mapper")
public class AppdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppdemoApplication.class, args);
    }

}
