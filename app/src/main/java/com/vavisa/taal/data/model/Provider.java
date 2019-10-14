package com.vavisa.taal.data.model;

import com.google.gson.annotations.SerializedName;

public class Provider {

    @SerializedName("provider_name")
    private String providerName;

    @SerializedName("provider_image")
    private Object providerImage;

    @SerializedName("provider_rating")
    private Float providerRating;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Object getProviderImage() {
        return providerImage;
    }

    public void setProviderImage(Object providerImage) {
        this.providerImage = providerImage;
    }

    public Float getProviderRating() {
        return providerRating;
    }

    public void setProviderRating(Float providerRating) {
        this.providerRating = providerRating;
    }
}
