package com.vavisa.taal.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Case {

    @Expose
    private Category category;

    @Expose
    private Status status;

    @SerializedName("case_id")
    private Integer caseId;

    @SerializedName("num_quotations")
    private Integer numQuotations;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getNumQuotations() {
        return numQuotations;
    }

    public void setNumQuotations(Integer numQuotations) {
        this.numQuotations = numQuotations;
    }
}
