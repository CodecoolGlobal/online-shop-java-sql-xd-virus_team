package com.codecool.xdvirus.onlineShop.controller;

import java.io.IOException;

public class CreateUserController {

    public void userCreation() throws IOException {
        String newUserLogin = UserInputController.stringUserInput("Enter a login: ");
        String newUserPassword = UserInputController.stringUserInput("Enter a password: ");

    }
}
