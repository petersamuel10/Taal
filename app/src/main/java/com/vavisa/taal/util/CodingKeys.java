package com.vavisa.taal.util;

public enum CodingKeys {
    LANGUAGE(""),
    AUTHORIZATION("Authorization"),
    ACCESS_TOKEN("token_id"),
    MESSAGE_KEY("message"),
    USER("user"),
    USER_LOGGED("user_logged"),
    SPORT("sport"),
    SPORTS("sports"),
    SINGLE_SELECTION("single_selection");

    private String key;

    CodingKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
