package com.vavisa.taal.util.dynamicViews;

import android.content.Context;

import com.vavisa.taal.data.model.RequestView;

public class DynamicViewFactory {

    private Context context;

    public DynamicViewFactory(Context context) {
        this.context = context;
    }

    public DynamicView createView(RequestView requestView) {
        switch (requestView.getType()) {
            case "text":
                return new DynamicEditText(context, requestView.getLabel());
            case "select":
                return new DynamicSpinner(context, requestView.getValue());
        }
        return null;
    }
}
