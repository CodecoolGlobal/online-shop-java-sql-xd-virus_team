package com.codecool.xdvirus.onlineShop.controller;

import com.codecool.xdvirus.onlineShop.view.RootView;

import java.io.IOException;


public class RootController {
    private RootView rootView = new RootView();
    private LoginController loginController = new LoginController();
    private final static int CUSTOMER_STATUS = 0;
    private final static int ADMIN_STATUS = 1;

    public RootController() {
        System.out.println("Welcome to OnlineShop");
        initializeApplication();
    }

    public void initializeApplication() {
        rootView.rootMenu();
        boolean isInitializing = true;
        try {
            while (isInitializing) {
                int userInput = rootView.validateUserInput();
                switch (userInput) {
                    case 1:
                        loggingIntoApplication();
                        isInitializing = false;
                        break;
                    case 2:
                        new CreateUserController().userCreation();
                        isInitializing = false;
                        break;
                    case 3:
                        isInitializing = false;
                        break;
                    default:
                        System.out.println("The input must be a number between 1-3.");
                }
            }

        } catch (IllegalArgumentException | IOException e) {
            System.out.println("The input must be a number!");
        }
    }


    private void loggingIntoApplication() {
        boolean loggingInProgress = true;
        while (loggingInProgress) {
            try {
                if (loginController.login()) {
                    int loginStatus = loginController.validatePermission(loginController.getLoggedUser());
                    if (loginStatus == CUSTOMER_STATUS) {
                        loadCustomerController();
                    } else if (loginStatus == ADMIN_STATUS) {
                        loadAdminController();
                    }
                    loggingInProgress = false;
                } else {
                    System.out.println("You write wrong login or password. Please try again.");
                }

            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    private void loadAdminController() {
        new AdminController().mainMenuController();
    }

    private void loadCustomerController() {
        new CustomerController().mainMenuController();
    }

}