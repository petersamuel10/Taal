package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.Address;
import com.vavisa.taal.data.network.main.MainApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AddressesRepository {

    private MainApi mainApi;

    @Inject
    AddressesRepository(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Observable<List<Address>> getMyAddresses(){
        return mainApi.getMyAddresses();
    }
}
