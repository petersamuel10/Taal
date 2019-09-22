package com.vavisa.taal.data.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("token_id")
    private String tokenId;

    private String errorMessage;

    public User() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
