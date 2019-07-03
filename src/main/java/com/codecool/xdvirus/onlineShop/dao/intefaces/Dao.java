package com.codecool.xdvirus.onlineShop.dao.intefaces;


import java.sql.SQLException;
import java.util.List;

public interface Dao <T> {
    List<T> readContent() throws SQLException;
    void createContent(T object) throws SQLException;
    void updateContent(T object) throws SQLException;
    void removeContent(int id) throws SQLException;
}
