package com.codecool.xdvirus.onlineShop.controller;

import com.codecool.xdvirus.onlineShop.dao.UsersDao;
import com.codecool.xdvirus.onlineShop.model.User;

import java.io.IOException;

public class CreateUserController {

    public void userCreation() throws IOException {
        String newUserLogin = UserInputController.stringUserInput("Enter a login: ");
        String newUserPassword = UserInputController.stringUserInput("Enter a password: ");
        new UsersDao().createContent(new User(newUserLogin, newUserPassword));
    }
}
