package com.codecool.xdvirus.onlineShop;

import com.codecool.xdvirus.onlineShop.controller.LoginController;
import com.codecool.xdvirus.onlineShop.dao.CategoryDao;
import com.codecool.xdvirus.onlineShop.model.Category;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            new LoginController().login();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}