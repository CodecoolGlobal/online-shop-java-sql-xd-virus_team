package com.codecool.xdvirus.onlineShop;

import com.codecool.xdvirus.onlineShop.dao.CategoryDao;
import com.codecool.xdvirus.onlineShop.model.Category;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            new CategoryDao().updateContent(new Category(2,"Kremówki"));
            System.out.println(new CategoryDao().readContent());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
