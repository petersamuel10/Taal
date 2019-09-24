package com.vavisa.taal.util;

import android.util.Patterns;

public class StringValidation {

    public static boolean isStringValid(String string) {
        return string != null && string.length()>1;
    }

    public static boolean isEmailValid(String email) {
        return email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isPhoneValid(String phone) {
        return phone != null && (phone.length()) == 8;
    }

    public static boolean isPasswordValid(String password) {
        return password != null && password.length() > 5;
    }
}
