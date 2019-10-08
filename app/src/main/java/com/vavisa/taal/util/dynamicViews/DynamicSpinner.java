package com.vavisa.taal.util.dynamicViews;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.vavisa.taal.R;

import java.util.List;

public class DynamicSpinner extends DynamicView<Spinner> {

    DynamicSpinner(Context context, List<String> values) {
        setView(new Spinner(context));
        initContainer(context);
        getView().setPadding(30, 50, 50, 50);
        addMargins();
        initAdapter(context, values);
    }

    private void initContainer(Context context){
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        getView().setLayoutParams(lp);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundResource(R.drawable.whit_rounded_background);
        relativeLayout.addView(getView());
    }

    private void initAdapter(Context context, List<String> values) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getView().setAdapter(adapter);
    }

    @Override
    public String getValue() {
        return getView().getSelectedItem().toString();
    }
}
