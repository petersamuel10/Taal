package com.vavisa.taal.ui.main.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.ProfileRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProfileViewModel extends ViewModel {

    private ProfileRepository profileRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<User>> liveData = new MutableLiveData<>();

    @Inject
    ProfileViewModel(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    MutableLiveData<Resource<User>> getLiveData() {
        return liveData;
    }

    void getUserProfile() {
        compositeDisposable.add(profileRepository.getUserProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> liveData.setValue(Resource.loading()))
                .subscribe(
                        user -> liveData.setValue(Resource.success(user)),
                        throwable -> liveData.setValue(Resource.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }

}
