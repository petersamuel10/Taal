package com.vavisa.taal.util;

import org.json.JSONObject;

import okhttp3.ResponseBody;

public class JsonParser {
    public static String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString(CodingKeys.ERROR_KEY.getKey());
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
