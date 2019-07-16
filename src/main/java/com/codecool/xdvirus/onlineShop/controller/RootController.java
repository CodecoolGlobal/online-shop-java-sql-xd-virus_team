package com.codecool.xdvirus.onlineShop.controller;

import com.codecool.xdvirus.onlineShop.view.RootView;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RootController {
    private RootView rootView = new RootView();

    public RootController() {
        System.out.println("Welcome to OnlineShop");
    }

    public void initializeApplication() {
        Scanner scanner = new Scanner(System.in);
        rootView.rootMenu();
        try {
            int userInput = scanner.nextInt();
            if (userInput >= 1 && userInput <= 3) {
                switch (userInput) {
                    case 1:
                        try {
                            new LoginController().login();
                        } catch (IOException e) {
                            e.getStackTrace();
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            } else {
                System.out.println("The input must be a number between 1-3.");
                initializeApplication();
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("The input must be a number between 1-3.");
            initializeApplication();
        }
    }

}
