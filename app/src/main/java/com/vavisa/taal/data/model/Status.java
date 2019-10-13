package com.vavisa.taal.data.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public enum Status {
    @SerializedName("Pending")
    PENDING,
    @SerializedName("Accepted")
    ACCEPTED;

    @NonNull
    @Override
    public String toString() {
        return this.name().substring(0,1).toUpperCase() + this.name().substring(1).toLowerCase();
    }
}
