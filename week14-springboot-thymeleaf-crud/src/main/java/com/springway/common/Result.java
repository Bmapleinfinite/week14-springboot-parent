package com.springway.common;

public enum Result {
    BAD_PARAMENT(101, "参数类型错误");

    private Integer code;
    private String message;

    Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
