package com.vavisa.taal.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestDetails {

    @SerializedName("CaseDetails")
    private CaseDetails caseDetails;

    @SerializedName("quotationDetails")
    private List<Quotation> quotations;

    public CaseDetails getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(CaseDetails caseDetails) {
        this.caseDetails = caseDetails;
    }

    public List<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
    }
}
