package com.codecool.xdvirus.onlineShop.controller;





import com.codecool.xdvirus.onlineShop.dao.UsersDao;
import com.codecool.xdvirus.onlineShop.model.User;

import java.io.IOException;


public class LoginController {


    private User loggedUser;

    public boolean login() throws IOException {
        String login = UserInputController.stringUserInput("Enter login: ");
        String password = UserInputController.stringUserInput("Enter password: ");
        for (User user : new UsersDao().readContent()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                //System.out.println("You logged succesfully!");
                loggedUser = new User(user.getId(), user.getLogin(), user.getPassword(), user.getPermission());
                return true;
            }
        }
        return false;
    }


    public int validatePermission(User user) {
        return user.getPermission();
    }

    public User getLoggedUser() {
        return loggedUser;
    }

}