package com.springway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.springway")
@MapperScan("com.springway.mapper")
public class App {
    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }
}
