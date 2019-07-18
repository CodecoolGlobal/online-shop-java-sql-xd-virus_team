package com.codecool.xdvirus.onlineShop.model;

import java.util.Date;

public class Order {

    private int id_order;
    private int basket_id;
    private String status;


    public Order(int id_order, int basket_id, String status) {
        this.id_order = id_order;
        this.basket_id = basket_id;
        this.status = status;
    }

    public Order(int basket_id, String status) {
        this.basket_id = basket_id;
        this.status = status;
    }

    public int getId_order() {
        return id_order;
    }

    public int getBasket_id() {
        return basket_id;
    }

    public String getStatus() {
        return status;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public void setBasket_id(int basket_id) {
        this.basket_id = basket_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
