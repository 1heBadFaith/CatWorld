package com.azhardevelop.example.com.model;

import com.google.gson.annotations.SerializedName;

public class ApiServiceCat {
    @SerializedName("name")
    private String name;

    @SerializedName("origin")
    private String origin;

    @SerializedName("description")
    private String description;

    @SerializedName("image_id")
    private String images;

    public ApiServiceCat(String name, String origins, String description, String images) {
        this.name = name;
        this.origin = origins;
        this.description = description;
        this.images = images;
    }


    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigins() {
        return origin;
    }

    public void setOrigins(String origins) {
        this.origin = origins;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
