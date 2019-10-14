package com.vavisa.taal.helper.dynamicViews;

import android.content.Context;

import com.vavisa.taal.data.model.Parameter;

public class DynamicViewFactory {

    private Context context;

    public DynamicViewFactory(Context context) {
        this.context = context;
    }

    public DynamicView createView(Parameter parameter) {
        switch (parameter.getType()) {
            case "text":
                return new DynamicEditText(context, parameter.getLabel(), true);
            case "textarea":
                return new DynamicEditText(context, parameter.getLabel(), false);
            case "select":
                return new DynamicSpinner(context, parameter.getValue());
        }
        return null;
    }
}
