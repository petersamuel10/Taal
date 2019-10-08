package com.vavisa.taal.data.model;

public class CaseField {
    private Integer id;
    private String value;

    public CaseField(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
