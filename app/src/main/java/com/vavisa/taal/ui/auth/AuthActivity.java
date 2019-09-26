package com.vavisa.taal.ui.auth;

import android.widget.Toast;

import com.vavisa.taal.base.BaseActivity;
import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.auth.AuthResource;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.ui.main.MainActivity;
import com.vavisa.taal.util.Preferences;
import com.vavisa.taal.util.ProgressDialog;

import javax.inject.Inject;

public class AuthActivity extends BaseActivity {

    @Inject
    public ViewModelProviderFactory providerFactory;

    @Inject
    public Preferences preferences;

    protected void consumeResponse(AuthResource<User> userAuthResource) {
        switch (userAuthResource.status) {
            case ERROR:
                ProgressDialog.getInstance().dismiss();
                Toast.makeText(this, userAuthResource.message, Toast.LENGTH_SHORT).show();
                break;

            case LOADING:
                ProgressDialog.getInstance().show(this);
                break;

            case AUTHENTICATED:
                ProgressDialog.getInstance().dismiss();
                start(MainActivity.class);
                break;

            case NOT_AUTHENTICATED:
                ProgressDialog.getInstance().dismiss();
                break;
        }
    }
}
