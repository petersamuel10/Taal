package com.vavisa.taal.ui.main.requests;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.databinding.FragmentMyRequestsBinding;

public class MyRequestsFragment extends BaseFragment {

    private FragmentMyRequestsBinding requestsBinding;

    public MyRequestsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        requestsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_requests, container, false);
        return requestsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        requestsBinding.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getActivity(), ""+tab.getPosition(), Toast.LENGTH_SHORT).show();
            }
            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
