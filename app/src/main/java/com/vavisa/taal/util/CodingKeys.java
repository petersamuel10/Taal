package com.vavisa.taal.util;

public enum CodingKeys {
    AUTHORIZATION("Authorization"),
    ACCESS_TOKEN("token_id"),
    MESSAGE_KEY("message"),
    USER_LOGGED("user_logged");

    private String key;

    CodingKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
