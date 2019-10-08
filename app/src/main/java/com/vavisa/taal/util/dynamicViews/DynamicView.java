package com.vavisa.taal.util.dynamicViews;

import android.view.View;
import android.widget.RelativeLayout;

public abstract class DynamicView<T extends View> {

    private T view;

    void setView(T view) {
        this.view = view;
    }

    public T getView(){
        return view;
    }

    public abstract String getValue();

    void addMargins() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(50, 50, 50, 0);
        view.setLayoutParams(layoutParams);
    }
}
