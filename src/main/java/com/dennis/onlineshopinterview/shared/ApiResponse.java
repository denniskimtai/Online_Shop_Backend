package com.dennis.onlineshopinterview.shared;

public class ApiResponse {
    public String data;
    public boolean success;

    public ApiResponse(String data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
