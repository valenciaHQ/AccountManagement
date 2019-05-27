package com.avalencia.transactions.model;

import java.io.Serializable;

public class ApiError implements Serializable {

    private Integer errorCode;
    private String message;

    public ApiError(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
