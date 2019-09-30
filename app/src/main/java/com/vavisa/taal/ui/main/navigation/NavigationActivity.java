package com.vavisa.taal.ui.main.navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseActivity;
import com.vavisa.taal.databinding.ActivityNavigationBinding;

public class NavigationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ActivityNavigationBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);
        mainBinding.setHandler(new NavigationEventHandler(this));
    }
}
