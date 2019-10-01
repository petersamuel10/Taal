package com.vavisa.taal.util.dynamicViews;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

public class DynamicEditText implements DynamicView{

    private EditText editText;

    DynamicEditText(Context context, String text) {
        editText = new EditText(context);
        editText.setHint(text);
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
