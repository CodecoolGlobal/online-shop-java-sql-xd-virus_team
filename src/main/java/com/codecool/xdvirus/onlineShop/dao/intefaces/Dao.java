package com.codecool.xdvirus.onlineShop.dao.intefaces;


import java.util.List;

public interface Dao <T> {
    List<T> readContent();
    void createContent(T object); //can't throw sql error becouse it should be universal for all database types
    void updateContent(T object) ;
    void removeContent(int id); //can resolve by custom exception
}
