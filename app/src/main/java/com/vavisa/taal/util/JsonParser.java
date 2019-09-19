package com.vavisa.taal.util;

import org.json.JSONObject;

import okhttp3.ResponseBody;

public class JsonParser {
    public static String getMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString(CodingKeys.MESSAGE_KEY.getKey());
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
