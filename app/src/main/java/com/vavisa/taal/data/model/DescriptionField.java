package com.vavisa.taal.data.model;

import com.google.gson.annotations.Expose;

public class DescriptionField {

    @Expose
    private String label;

    @Expose
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
