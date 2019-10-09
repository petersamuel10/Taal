package com.vavisa.taal.util.dynamicViews;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import com.vavisa.taal.R;

public class DynamicEditText implements DynamicView{

    private EditText editText;

    DynamicEditText(Context context, String text, boolean singleLine) {
        editText = new EditText(context);
        editText.setHint(text);
        editText.setSingleLine(singleLine);
        editText.setBackgroundResource(R.drawable.whit_rounded_background);
        editText.setTextAppearance(context, R.style.ParameterText);
        editText.setPadding(50,50,50,50);
        ViewDecorator.addMargins(editText, 50, 50, 50, 0);
    }

    @Override
    public View getView() {
        return editText;
    }

    @Override
    public String getValue() {
        return editText.getText().toString();
    }
}
