package com.vavisa.taal.ui.main.requests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;

public class RequestsFragment extends BaseFragment {

    public RequestsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_requests, container, false);
    }

}
