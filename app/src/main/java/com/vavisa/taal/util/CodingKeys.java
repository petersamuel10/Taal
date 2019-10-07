package com.vavisa.taal.util;

public enum CodingKeys {
    ACCEPT_LANGUAGE("Accept-Language"),
    AUTHORIZATION("Authorization"),
    VERSION_KEY("Version"),
    ACCESS_TOKEN("access_token"),
    TOKEN_TYPE("token_type"),
    ERROR_KEY("error"),
    USER_KEY("user"),
    USER_LOGGED("user_logged");

    private String key;

    CodingKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
