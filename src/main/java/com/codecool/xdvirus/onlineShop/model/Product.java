package com.codecool.xdvirus.onlineShop.model;


public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;
    private String availibility;
    private int category;

    public Product(int id, String name, double price, int amount, String isAvailable, int category) {
        this.id =id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.availibility = isAvailable;
        this.category = category;
    }


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

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.price+" "+this.amount+" "+this.availibility+" "+this.category;
    }
}
