package com.vavisa.taal.ui.main.home.request;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.data.model.RequestView;
import com.vavisa.taal.databinding.FragmentAddRequestBinding;
import com.vavisa.taal.util.dynamicViews.DynamicView;
import com.vavisa.taal.util.dynamicViews.DynamicViewFactory;

import java.util.ArrayList;

public class AddRequestFragment extends BaseFragment {

    private FragmentAddRequestBinding binding;

    public AddRequestFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_request, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        DynamicViewFactory viewFactory = new DynamicViewFactory(getActivity());
        ArrayList<DynamicView> viewsList = new ArrayList<>();
        RequestView text = new RequestView();
        text.setLabel("Room Size");
        text.setType("text");

        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");
        values.add("third");
        values.add("fourth");
        values.add("fifth");

        RequestView spinner = new RequestView();
        spinner.setType("select");
        spinner.setValue(values);

        viewsList.add(viewFactory.createView(text));
        viewsList.add(viewFactory.createView(spinner));
        binding.setViewsList(viewsList);


    }
}
