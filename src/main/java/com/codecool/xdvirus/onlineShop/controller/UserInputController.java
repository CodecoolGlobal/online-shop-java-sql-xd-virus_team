package com.codecool.xdvirus.onlineShop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class UserInputController {


     static String stringUserInput(String keyString) throws IOException {
        System.out.println(keyString);
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
