package com.codecool.xdvirus.onlineShop.dao.intefaces;


import java.util.List;

public interface Dao <T> {
    List<T> readContent();
    void writeContent(T object);
    void updateContent(T object);
    void removeContent(T object);
}
