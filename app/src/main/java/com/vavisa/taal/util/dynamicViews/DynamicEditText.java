package com.vavisa.taal.util.dynamicViews;

import android.content.Context;
import android.os.Build;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import com.vavisa.taal.R;

public class DynamicEditText extends DynamicView<EditText>{

    @RequiresApi(api = Build.VERSION_CODES.M)
    DynamicEditText(Context context, String text, boolean singleLine) {
        setView(new EditText(context));
        getView().setHint(text);
        getView().setSingleLine(singleLine);
        getView().setBackgroundResource(R.drawable.whit_rounded_background);
        getView().setTextAppearance(R.style.ParameterText);
        getView().setPadding(50,50,50,50);
        addMargins();
    }

    private void initContainer(){

    }

    @Override
    public String getValue() {
        return getView().getText().toString();
    }
}
