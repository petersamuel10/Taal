package com.vavisa.taal.ui.main.profile.addresses;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.Address;
import com.vavisa.taal.data.network.main.Resource;

import java.util.List;

import javax.inject.Inject;

public class AddressesViewModel extends ViewModel {

    private MutableLiveData<Address> selectedAddress = new MutableLiveData<>();
    private MutableLiveData<Resource<List<Address>>> addressesLiveData = new MutableLiveData<>();

    @Inject
    public AddressesViewModel() {
    }

    public void setSelectedAddress(Address address) {
        selectedAddress.setValue(address);
    }

    public MutableLiveData<Address> getSelectedAddress() {
        return selectedAddress;
    }

    public MutableLiveData<Resource<List<Address>>> getAddressesLiveData() {
        return addressesLiveData;
    }

    @Override
    protected void onCleared() {
    }
}