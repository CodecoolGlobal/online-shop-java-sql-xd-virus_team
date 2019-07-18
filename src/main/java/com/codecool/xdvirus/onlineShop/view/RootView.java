package com.codecool.xdvirus.onlineShop.view;


import java.util.Scanner;

public class RootView {
    private int userIntegerInput;

    public void rootMenu() {
        System.out.println("Please choose an option. ");
        System.out.println("1. LOG IN");
        System.out.println("2. CREATE NEW ACCOUNT");
        System.out.println("3. QUIT");
    }

    public int validateUserInput() {
        boolean isNotValid = true;
        while (isNotValid) {
            Scanner scanner = new Scanner(System.in);
            try {
                userIntegerInput = Integer.valueOf(scanner.nextLine());
                isNotValid = false; //move it into validation
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number!");
            }
        }
        return userIntegerInput;
    }
}