package com.springway.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@SpringBootConfiguration
public class MyBatisPlusConfig {
    
    @Bean
    public ISqlInjector iSqlInjector() {
        return new LogicSqlInjector();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
