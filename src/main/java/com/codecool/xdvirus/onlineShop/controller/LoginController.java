package com.codecool.xdvirus.onlineShop.controller;


import com.codecool.xdvirus.onlineShop.dao.UsersDao;
import com.codecool.xdvirus.onlineShop.model.User;

import java.io.IOException;


public class LoginController {

    public void login() throws IOException {
        String login = UserInputController.stringUserInput("Enter login: ");
        String password = UserInputController.stringUserInput("Enter password: ");
        for (User user : new UsersDao().readContent()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("You logged succesfully!");
                validatePermission(user);
            } else {
                System.out.println("Wrong login or password.");
            }
        }

    }


    public void validatePermission(User user) {
        if (user.getPermission() == 0) {
            System.out.println("Jesteś zakupowiczem!");
        } else {
            System.out.println("Jesteś czarodziejem Harry!");
        }
    }
}