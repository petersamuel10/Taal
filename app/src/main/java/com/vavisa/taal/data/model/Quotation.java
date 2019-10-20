package com.vavisa.taal.data.model;

import com.google.gson.annotations.SerializedName;

public class Quotation {

    private Integer id;

    private String price;

    private Provider provider;

    @SerializedName("extra_notes")
    private String extraNotes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getExtraNotes() {
        return extraNotes;
    }

    public void setExtraNotes(String extraNotes) {
        this.extraNotes = extraNotes;
    }
}
