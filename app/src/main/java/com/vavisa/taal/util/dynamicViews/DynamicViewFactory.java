package com.vavisa.taal.util.dynamicViews;

import android.content.Context;
import android.view.View;

public class DynamicViewFactory {

    private Context context;

    public DynamicViewFactory(Context context) {
        this.context = context;
    }

    public View getView(String type, String text) {
        switch (type) {
            case "text":
                return new DynamicTextView(context).create(text);
            default:
                return new DynamicTextView(context).create(text);
        }
    }
}
