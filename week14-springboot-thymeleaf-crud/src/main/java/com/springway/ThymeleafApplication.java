package com.springway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springway.mapper")
public class ThymeleafApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }
}
