package com.example.hitcapp;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String price;
    private int imageResource;

    public Product(String name, String price, int imageResource) {
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getName() { return name; }
    public String getPrice() { return price; }
    public int getImageResource() { return imageResource; }
}