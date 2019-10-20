package com.vavisa.taal.ui.main.profile.addresses;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.Address;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.AddressesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AddressesViewModel extends ViewModel {

    private AddressesRepository addressesRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<List<Address>>> addressesLiveData = new MutableLiveData<>();

    @Inject
    AddressesViewModel(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    MutableLiveData<Resource<List<Address>>> getAddressesLiveData() {
        return addressesLiveData;
    }

    void getMyAddresses() {
        compositeDisposable.add(addressesRepository.getMyAddresses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> addressesLiveData.setValue(Resource.loading()))
                .subscribe(
                        addresses -> addressesLiveData.setValue(Resource.success(addresses)),
                        throwable -> addressesLiveData.setValue(Resource.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}