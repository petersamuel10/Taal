package com.vavisa.taal.data.model;

import com.google.gson.annotations.Expose;

public class Quotation {

    @Expose
    private String price;

    @Expose
    private Provider provider;

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
}
