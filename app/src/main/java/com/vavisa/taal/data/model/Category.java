package com.vavisa.taal.data.model;

import com.google.gson.annotations.Expose;

public class Category {

    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
