package com.vavisa.taal.ui.main.requests.invoice;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.GeneralResponse;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.InvoiceRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class InvoiceViewModel extends ViewModel {

    private InvoiceRepository invoiceRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<GeneralResponse>> liveData = new MutableLiveData<>();

    @Inject
    public InvoiceViewModel(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public MutableLiveData<Resource<GeneralResponse>> getLiveData() {
        return liveData;
    }

    public void acceptQuotation(Integer caseId, Integer providerId, Integer quotationId, Integer addressId){
        compositeDisposable.add(invoiceRepository.acceptQuotation(caseId, providerId, quotationId, addressId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> liveData.setValue(Resource.loading()))
                .subscribe(
                        response -> liveData.setValue(Resource.success(response)),
                        throwable -> liveData.setValue(Resource.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}
