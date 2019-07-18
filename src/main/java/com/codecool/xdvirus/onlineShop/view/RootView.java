package com.codecool.xdvirus.onlineShop.view;


import java.util.Scanner;

public class RootView {
    private int userIntegerInput;
    private String userStringInput;

    public void rootMenu() {
        System.out.println("Please choose an option. ");
        System.out.println("1. LOG IN");
        System.out.println("2. CREATE NEW ACCOUNT");
        System.out.println("3. QUIT");
    }

    public int validateIntegerUserInput() {
        boolean isNotValid = true;
        while (isNotValid) {
            Scanner scanner = new Scanner(System.in);
            try {
                userIntegerInput = Integer.valueOf(scanner.nextLine());
                isNotValid = false;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number!");
            }
        }
        return userIntegerInput;
    }

    public String stringUserInput(String message) {
        boolean isNotValid = true;
        while (isNotValid) {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            try {
                userStringInput = scanner.nextLine();
                isNotValid = false;
            } catch (NumberFormatException e) {
                System.out.println("Input must be correct!");
            }
        }
        return userStringInput;
    }
}