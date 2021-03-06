package com.vavisa.taal.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Case {

    private List<DescriptionField> fields;

    private Category category;

    private Status status;

    @SerializedName("case_id")
    private Integer caseId;

    @SerializedName("num_quotations")
    private Integer numQuotations;

    @SerializedName("is_edit")
    private Boolean isEdit;

    @SerializedName("is_delete")
    private Boolean isDelete;

    public List<DescriptionField> getFields() {
        return fields;
    }

    public void setFields(List<DescriptionField> fields) {
        this.fields = fields;
    }

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

    public Boolean getEdit() {
        return isEdit;
    }

    public void setEdit(Boolean edit) {
        isEdit = edit;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        for (DescriptionField field : fields) {
            description.append(field.getLabel().concat(" : ").concat(field.getValue()).concat("\n"));
        }
        return description.toString().length() != 0 ?
                description.toString().substring(0, description.length() - 1) :
                description.toString();
    }
}
