package com.vavisa.taal.ui.main;

import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.ui.main.home.HomeFragment;
import com.vavisa.taal.ui.main.profile.ProfileFragment;
import com.vavisa.taal.ui.main.requests.RequestsFragment;

public class MainEventHandler {

    private MainActivity activity;

    MainEventHandler(MainActivity activity) {
        this.activity = activity;
    }

    public boolean onNavigationClick(@NonNull MenuItem item) {
        BaseFragment fragment = null;
        switch (item.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                break;

            case R.id.requests:
                fragment = new RequestsFragment();
                break;

            case R.id.profile:
                fragment = new ProfileFragment();
                break;
        }
        if (fragment != null) {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
        }
        return true;
    }
}
