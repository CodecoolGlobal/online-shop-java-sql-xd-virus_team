package com.codecool.xdvirus.onlineShop.model;

public class Customer {

    private int id;
    private String name;
    private String email;
    private int order_id;

    public Customer(int id, String name, String email, int order_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getOrder_id() {
        return order_id;
    }
    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.email+" "+this.order_id;
    }
}
