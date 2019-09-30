package com.vavisa.taal.util.dynamicViews;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class DynamicTextView implements DynamicView{

    private Context context;

    DynamicTextView(Context context) {
        this.context = context;
    }

    @Override
    public View create(String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        return textView;
    }
}
