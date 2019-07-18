package com.codecool.xdvirus.onlineShop;

import com.codecool.xdvirus.onlineShop.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductIterator implements Iterator {


    private int index;
    List<Product> productsList;

    public ProductIterator(List<Product> list){
        this.productsList = list;
    }


    @Override
    public boolean hasNext() {
        if (index < productsList.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Product next() {
        return productsList.get(index++);
    }

    @Override
    public void remove() {
        this.index = 0;
    }
    public List<Product> getList(){
        return this.productsList;
    }
}


