package com.vavisa.taal.base;

import android.widget.Toast;

import com.vavisa.taal.util.ProgressDialog;

import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {

    public BaseFragment() {}

    public void showProgress() {
        ProgressDialog.getInstance().show(getActivity());
    }

    public void hideProgress() {
        ProgressDialog.getInstance().dismiss();
    }

    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
