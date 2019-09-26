package com.vavisa.taal.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.lifecycle.MutableLiveData;

import com.vavisa.taal.R;

public class FormValidation {

    private Context context;

    public FormValidation(Context context) {
        this.context = context;
    }

    public boolean isValidName(String name, MutableLiveData<String> nameError){
        if (name != null && !TextUtils.isEmpty(name)){
            nameError.setValue(null);
            return true;
        } else {
            nameError.setValue(context.getResources().getString(R.string.valid_name));
            return false;
        }
    }

    public boolean isValidEmail(String email, MutableLiveData<String> emailError){
        if (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailError.setValue(null);
            return true;
        } else {
            emailError.setValue(context.getResources().getString(R.string.valid_email));
            return false;
        }
    }

    public boolean isValidPhone(String phone, MutableLiveData<String> phoneError){
        if (phone != null && phone.length() > 7){
            phoneError.setValue(null);
            return true;
        } else {
            phoneError.setValue(context.getResources().getString(R.string.valid_phone));
            return false;
        }
    }

    public boolean isValidPassword(String password, MutableLiveData<String> passwordError){
        if (password != null && password.length() > 5) {
            passwordError.setValue(null);
            return true;
        } else {
            passwordError.setValue(context.getResources().getString(R.string.valid_password));
            return false;
        }
    }

    public boolean isPasswordMatch(String password, String confirmPassword, MutableLiveData<String> passwordError){
        if (password != null && password.equals(confirmPassword)) {
            passwordError.setValue(null);
            return true;
        } else {
            passwordError.setValue(context.getResources().getString(R.string.valid_password));
            return false;
        }
    }
}