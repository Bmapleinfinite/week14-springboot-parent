package com.springway.observer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springway.observer.Observer;
import com.springway.observer.Subject;

@Component
public class SubjectImpl implements Subject {

    @Autowired
    private List<Observer> observers;

    @Override
    public void notifyOperation(String message) {
        for (Observer observer : observers) {
            observer.notifyOperation(message);
        }
    }
    
}
