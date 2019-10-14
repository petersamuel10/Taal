package com.vavisa.taal.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestDetails {

    @SerializedName("CaseDetails")
    private Case caseDetails;

    @SerializedName("quotationDetails")
    private List<Quotation> quotations;

    public Case getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(Case caseDetails) {
        this.caseDetails = caseDetails;
    }

    public List<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
    }
}
