package com.vavisa.taal.helper.dynamicViews;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;
import com.vavisa.taal.R;

public class DynamicEditText implements DynamicView{

    private EditText editText;
    private TextInputLayout textInputLayout;

    DynamicEditText(Context context, String text, boolean singleLine) {
        editText = new EditText(context);
        editText.setSingleLine(singleLine);
        editText.setTextAppearance(context, R.style.ParameterText);
        editText.setBackgroundResource(R.drawable.whit_rounded_background);

        wrapViewInContainer(context, text);
        ViewDecorator.addMargins(textInputLayout, 50, 50, 50, 0);
    }

    private void wrapViewInContainer(Context context, String text){
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        textInputLayout = new TextInputLayout(context, null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox);
        LinearLayout.LayoutParams textInputLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        textInputLayout.setPadding(50,10,50,10);
        textInputLayout.setBackgroundResource(R.drawable.whit_rounded_background);
        textInputLayout.setLayoutParams(textInputLayoutParams);
        textInputLayout.addView(editText, editTextParams);
        textInputLayout.setHint(text);
    }

    @Override
    public View getView() {
        return textInputLayout;
    }

    @Override
    public String getValue() {
        if (TextUtils.isEmpty(editText.getText().toString()))
            return null;
        return editText.getText().toString();
    }
}
