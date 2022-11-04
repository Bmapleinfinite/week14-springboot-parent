package com.springway.exception;

public class RedisException extends RuntimeException {

    private String message;

    public RedisException() {
    }

    public RedisException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "A Redis Error: " + message;
    }
}
