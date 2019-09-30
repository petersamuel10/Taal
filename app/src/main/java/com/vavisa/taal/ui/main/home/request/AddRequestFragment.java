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
import com.vavisa.taal.databinding.FragmentAddRequestBinding;
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
        ArrayList<View> viewsList = new ArrayList<>();
        viewsList.add(viewFactory.getView("text", "Room size"));
        viewsList.add(viewFactory.getView("text", "Paint Color"));
        binding.setViewsList(viewsList);
    }
}
