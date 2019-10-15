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
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.data.model.Address;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentAddressesBinding;
import com.vavisa.taal.ui.main.navigation.NavigationActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AddressesFragment extends BaseFragment {

    private FragmentAddressesBinding addressesBinding;

    public AddressesFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addressesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_addresses, container, false);
        return addressesBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setUpActionMenu();
        AddressesViewModel addressesViewModel = ViewModelProviders.of(this, providerFactory).get(AddressesViewModel.class);
        addressesViewModel.getAddressesLiveData().observe(this, this::consumeAddressesResponse);
        addressesViewModel.getMyAddresses();
    }

    private void consumeAddressesResponse(Resource<List<Address>> listResource) {
        switch (listResource.status){
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(listResource.error);
                break;

            case SUCCESS:
                hideProgress();
                if (listResource.data != null)
                    addressesBinding.setAddressList(listResource.data);
                break;
        }
    }

    private void setUpActionMenu() {
        NavigationActivity activity = (NavigationActivity) getActivity();
        if (activity != null && activity.getSupportActionBar() != null) {
            activity.setSupportActionBar(addressesBinding.actionsToolbar);
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
