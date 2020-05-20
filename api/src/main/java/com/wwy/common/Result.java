package com.wwy.common;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private int code;
    private String message;
    private T data;
    private boolean ok = true;

    public static <T> Result<T> success(T data) {
        Result<T> resultVo = new Result<T>();
        resultVo.setOk(true);
        resultVo.setCode(200);
        resultVo.setData(data);
        return resultVo;
    }

    public static <T> Result<T> error(int code, String message) {
        Result<T> resultVo = new Result<T>();
        resultVo.setOk(false);
        resultVo.setCode(200);
        resultVo.setMessage(message);
        return resultVo;
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

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
