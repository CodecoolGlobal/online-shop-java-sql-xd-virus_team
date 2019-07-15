package com.codecool.xdvirus.onlineShop.dao.intefaces;


import java.util.List;

public interface Dao <T> {
    List<T> readContent(); //nie może obśługiwać wyjątku tylko dla sql, tylko ma być do kazdego typu bazy danych CSV itp
    void createContent(T object);
    void updateContent(T object);
    void removeContent(int id);
}
