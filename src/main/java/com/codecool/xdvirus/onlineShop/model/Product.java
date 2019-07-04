package com.codecool.xdvirus.onlineShop.model;


public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;
    private boolean isAvailable;
    private int category;

    public Product(int id, String name, double price, int amount, boolean isAvailable, int category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.price+" "+this.amount+" "+this.isAvailable+" "+this.category;
    }
}
