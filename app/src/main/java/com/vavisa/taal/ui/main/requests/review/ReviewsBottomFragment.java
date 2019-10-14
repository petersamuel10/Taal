package com.vavisa.taal.ui.main.requests.review;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.vavisa.taal.R;

public class ReviewsBottomFragment extends BottomSheetDialogFragment {

    public ReviewsBottomFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reviews_bottom, container, false);
    }


}
