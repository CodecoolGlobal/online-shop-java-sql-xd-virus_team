package com.codecool.xdvirus.onlineShop.controller;

import com.codecool.xdvirus.onlineShop.dao.UsersDao;
import com.codecool.xdvirus.onlineShop.model.User;
import com.codecool.xdvirus.onlineShop.view.RootView;

import java.io.IOException;

public class CreateUserController {
    public void userCreation() {
        String newUserLogin = new RootView().stringUserInput("Enter a login");
        String newUserPassword = new RootView().stringUserInput("Enter a password");
        new UsersDao().createContent(new User(newUserLogin, newUserPassword));
        new RootController().initializeApplication();
    }
}
