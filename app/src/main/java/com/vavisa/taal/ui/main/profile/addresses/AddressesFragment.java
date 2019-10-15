package com.vavisa.taal.ui.main.profile.addresses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.ui.main.navigation.NavigationActivity;

public class AddressesFragment extends BaseFragment {

    public AddressesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addresses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setUpActionMenu(view);
    }

    private void setUpActionMenu(View view) {
        Toolbar myToolbar = view.findViewById(R.id.actions_toolbar);
        NavigationActivity activity = (NavigationActivity) getActivity();
        if (activity != null && activity.getSupportActionBar() != null) {
            activity.setSupportActionBar(myToolbar);
            activity.getSupportActionBar().setTitle("");
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_actions, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_address) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
