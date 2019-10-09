package com.vavisa.taal.util.dynamicViews;

import android.view.View;

import android.widget.RelativeLayout;

class ViewDecorator {
    static void addMargins(View view, int left, int top, int right, int bottom) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(left, top, right, bottom);
        view.setLayoutParams(layoutParams);
    }
}