package com.vavisa.taal.helper.dynamicViews;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.vavisa.taal.R;

import java.util.List;

public class DynamicSpinner implements DynamicView {

    private RelativeLayout relativeLayout;
    private Spinner spinner;

    DynamicSpinner(Context context, List<String> values) {
        spinner = new Spinner(context);
        spinner.setPadding(30, 50, 50, 50);
        wrapViewInContainer(context);
        ViewDecorator.addMargins(relativeLayout, 50, 50, 50, 0);
        initAdapter(context, values);
    }

    private void wrapViewInContainer(Context context){
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        spinner.setLayoutParams(lp);
        relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundResource(R.drawable.whit_rounded_background);
        relativeLayout.addView(spinner);
    }

    private void initAdapter(Context context, List<String> values) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public View getView() {
        return relativeLayout;
    }

    @Override
    public String getValue() {
        return spinner.getSelectedItem().toString();
    }
}
