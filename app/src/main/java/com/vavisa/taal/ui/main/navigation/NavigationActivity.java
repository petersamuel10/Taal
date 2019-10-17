package com.vavisa.taal.ui.main.navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseActivity;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.databinding.ActivityNavigationBinding;
import com.vavisa.taal.helper.SharedViewModel;

public class NavigationActivity extends BaseActivity {

    public ActivityNavigationBinding mainBinding;

    public SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);
        NavigationEventHandler navigationHandler = new NavigationEventHandler(this);
        mainBinding.setSelectedItemId(R.id.home);
        mainBinding.setHandler(navigationHandler);
        sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
    }

}
