package com.springway.exception;

public class CommonException extends RuntimeException {
    
    private Integer code;
    private String message;

    public CommonException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return "code: " + code + " message: " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
