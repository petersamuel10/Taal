package com.vavisa.taal.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CaseRequest {

    @SerializedName("category_id")
    private Integer categoryId;

    private List<CaseField> fields;

    public CaseRequest(Integer categoryId, List<CaseField> fields) {
        this.categoryId = categoryId;
        this.fields = fields;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<CaseField> getFields() {
        return fields;
    }

    public void setFields(List<CaseField> fields) {
        this.fields = fields;
    }
}
