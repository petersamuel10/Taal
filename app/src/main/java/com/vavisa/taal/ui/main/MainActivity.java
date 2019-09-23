package com.vavisa.taal.ui.main;

import android.os.Bundle;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseActivity;
import com.vavisa.taal.ui.main.profile.ProfileFragment;
import com.vavisa.taal.util.Preferences;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.content, new ProfileFragment()).commit();
    }
}
