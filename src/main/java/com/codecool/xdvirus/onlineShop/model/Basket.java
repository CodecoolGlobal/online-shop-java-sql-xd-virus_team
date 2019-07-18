package com.codecool.xdvirus.onlineShop.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {

    private int id;
    private Iterator iterator;
    private ArrayList<Product> products;
    private int product_id;
    private int quantity_of_product;
    private int order_id;

    public Basket(int id, int product_id, int quantity_of_product, int order_id) {
        this.id = id;
        this.product_id = product_id;
        this.quantity_of_product = quantity_of_product;
        this.order_id = order_id;
    }
    public Basket(int product_id, int quantity_of_product){
        this.product_id = product_id;
        this.quantity_of_product = quantity_of_product;
    }

    public Iterator getIterator() {

        return iterator;
    }

    public void addProduct(Product product, Integer amount ) {

        products.add(product);

    }

    public void deleteProduct(Product product){

        products.remove(product);

    }

    public int getId() {
        return id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getQuantity_of_product() {
        return quantity_of_product;
    }

    @Override
    public String toString() {
        return "Id: " + id + " ,prod_id: " + product_id + " ,quantity: " + quantity_of_product + " ,order id: " + order_id;
    }
}
