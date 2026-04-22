package com.example.hitcapp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Product implements Serializable {
    @SerializedName("title")
    private String name;
    
    @SerializedName("price")
    private double priceValue;
    
    @SerializedName("image")
    private String imageUrl;
    
    @SerializedName("description")
    private String description;

    public String getName() { return name; }
    public String getPrice() { return String.format("%.2f $", priceValue); }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }
}