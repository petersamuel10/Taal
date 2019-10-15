package com.vavisa.taal.ui.main.requests.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.data.model.Case;
import com.vavisa.taal.data.model.Status;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentMyRequestsBinding;

import java.util.List;

public class MyRequestsFragment extends BaseFragment {

    private MyRequestsViewModel myRequestsViewModel;
    private FragmentMyRequestsBinding requestsBinding;

    public MyRequestsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        requestsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_requests, container, false);
        return requestsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        myRequestsViewModel = ViewModelProviders.of(this, providerFactory).get(MyRequestsViewModel.class);
        myRequestsViewModel.getLiveData().observe(this, this::ConsumeResponse);
        myRequestsViewModel.getPendingCases();
        handleTabSelection();
    }

    private void handleTabSelection() {
        requestsBinding.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0)
                    myRequestsViewModel.filterCaseStatus(Status.PENDING);
                else
                    myRequestsViewModel.filterCaseStatus(Status.ACCEPTED);
            }
            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void ConsumeResponse(Resource<List<Case>> listResource) {
        switch (listResource.status){
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(listResource.error);
                break;

            case SUCCESS:
                hideProgress();
                displayRequestsList(listResource.data);
        }
    }

    private void displayRequestsList(List<Case> data) {
        requestsBinding.setRequestsList(data);
    }
}
