package com.vavisa.taal.util.dynamicViews;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class DynamicSpinner implements DynamicView {

    private Spinner spinner;

    DynamicSpinner(Context context, List<String> values) {
        spinner = new Spinner(context);
        initAdapter(context, values);
    }

    private void initAdapter(Context context, List<String> values) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public View getView() {
        return spinner;
    }

    @Override
    public String getValue() {
        return spinner.getSelectedItem().toString();
    }
}
