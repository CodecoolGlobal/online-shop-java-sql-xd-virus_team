package com.codecool.xdvirus.onlineShop.model;


public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;
    private String availibility;
    private int category;

    public Product(String name, double price, int amount, String isAvailable, int category) {

        this.name = name;
        this.price = price;
        this.amount = amount;
        this.availibility = isAvailable;
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

    public String isAvailable() {
        return availibility;
    }

    public int getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.price+" "+this.amount+" "+this.availibility+" "+this.category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAvailibility(String availibility) {
        this.availibility = availibility;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
