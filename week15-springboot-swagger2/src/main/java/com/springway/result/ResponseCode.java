package com.springway.result;

public enum ResponseCode {

    SUCCESS(0, "成功"),
    Failure(-1,"失败"),
    NULL_POINT_ERROR(100,"空指针异常"),
    SQL_ERROR(101,"SQL异常"),
    SYSTEM_ERROR(102,"系统异常");

    private Integer code;
    private String message;

    ResponseCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
