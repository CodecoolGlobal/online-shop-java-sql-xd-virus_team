package com.codecool.xdvirus.onlineShop.model;

public class Admin {
    private int id;
    private String name;

    public Admin(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return this.id + " " +
                this.name;
    }
}
