package com.vavisa.taal.helper;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.Address;
import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.model.Invoice;
import com.vavisa.taal.data.model.Quotation;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<Integer> caseIdLiveData = new MutableLiveData<>();
    private MutableLiveData<Integer> providerIdLiveData = new MutableLiveData<>();
    private MutableLiveData<Quotation> acceptedQuotation = new MutableLiveData<>();
    private MutableLiveData<Address> selectedAddress = new MutableLiveData<>();
    private MutableLiveData<Category> selectedCategory = new MutableLiveData<>();
    private MutableLiveData<Invoice> requestInvoice = new MutableLiveData<>();

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

    public void setSelectedAddress(Address address) {
        selectedAddress.setValue(address);
    }

    public MutableLiveData<Address> getSelectedAddress() {
        return selectedAddress;
    }

    public MutableLiveData<Category> getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category category) {
        selectedCategory.setValue(category);
    }

    public MutableLiveData<Invoice> getRequestInvoice() {
        return requestInvoice;
    }

    public void setRequestInvoice(Invoice requestInvoice) {
        this.requestInvoice.setValue(requestInvoice);
    }
}
