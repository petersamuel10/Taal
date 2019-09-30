package com.vavisa.taal.ui.main;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseActivity;
import com.vavisa.taal.databinding.ActivityMainBinding;
import com.vavisa.taal.util.Preferences;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setHandler(new NavigationEventHandler(this));
    }
}
