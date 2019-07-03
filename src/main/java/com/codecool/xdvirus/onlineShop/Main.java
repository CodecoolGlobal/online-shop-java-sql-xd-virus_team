package com.codecool.xdvirus.onlineShop;

import com.codecool.xdvirus.onlineShop.dao.CategoryDao;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            new CategoryDao().removeContent(2);
            System.out.println(new CategoryDao().readContent());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
