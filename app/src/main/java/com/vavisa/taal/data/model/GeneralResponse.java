package com.vavisa.taal.data.model;

import com.google.gson.annotations.Expose;

public class GeneralResponse {

    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}