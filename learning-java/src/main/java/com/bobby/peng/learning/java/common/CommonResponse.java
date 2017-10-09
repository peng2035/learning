package com.bobby.peng.learning.java.common;

/**
 * Created by peng2035 on 16-12-3.
 */
public class CommonResponse<T> {

    private int code;

    private String message;

    private T data;

    public CommonResponse() {
    }

    public CommonResponse(T data) {
        this.data = data;
    }

    public CommonResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
