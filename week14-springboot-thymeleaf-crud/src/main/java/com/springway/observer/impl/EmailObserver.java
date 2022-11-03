package com.springway.observer.impl;

import org.springframework.stereotype.Component;

import com.springway.observer.Observer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmailObserver implements Observer{

    @Override
    public void notifyOperation(String message) {
        log.error("notify by Email");  
    }
    
}
