package com.vavisa.taal.helper;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.Quotation;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<Integer> caseIdLiveData = new MutableLiveData<>();
    private MutableLiveData<Integer> providerIdLiveData = new MutableLiveData<>();
    private MutableLiveData<Quotation> acceptedQuotation = new MutableLiveData<>();

    public MutableLiveData<Integer> getCaseIdLiveData() {
        return caseIdLiveData;
    }

    public void setCaseIdLiveData(Integer caseId) {
        caseIdLiveData.setValue(caseId);
    }

    public MutableLiveData<Integer> getProviderIdLiveData() {
        return providerIdLiveData;
    }

    public void setAcceptedQuotation(Quotation quotation) {
        acceptedQuotation.setValue(quotation);
    }

    public MutableLiveData<Quotation> getAcceptedQuotation() {
        return acceptedQuotation;
    }

    public void setProviderIdLiveData(Integer providerId) {
        providerIdLiveData.setValue(providerId);
    }
}
