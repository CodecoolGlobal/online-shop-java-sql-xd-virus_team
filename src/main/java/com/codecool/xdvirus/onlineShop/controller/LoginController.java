package com.codecool.xdvirus.onlineShop.controller;


import com.codecool.xdvirus.onlineShop.dao.UsersDao;
import com.codecool.xdvirus.onlineShop.model.User;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController {


    public void login() throws IOException {
        try {
            String login = UserInputController.stringUserInput("Enter login: ");
            String password = UserInputController.stringUserInput("Enter password: ");
            for (User user : new UsersDao().readContent()) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    System.out.println("You logged succesfully!");
                }
            }
            System.out.println("Wrong login or password.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}