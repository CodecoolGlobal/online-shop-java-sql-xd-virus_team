package com.codecool.xdvirus.onlineShop.model;

import java.util.List;

public class Category {

    private int id;
    private String name;
    private boolean isAvailable;
    private List<Product> products;

    public String Category() {

        return this.name;
    }

    public List<Product> getProducts() {

        return products;
    }


}

