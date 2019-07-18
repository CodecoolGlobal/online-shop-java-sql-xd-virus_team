package com.codecool.xdvirus.onlineShop.view;

public class AdminView {

    public void adminMainMenu() {

        System.out.println("You logged as admin");
        System.out.println("(1.) Show all products.");
        System.out.println("(2.) Show all orders.");
        System.out.println("(3.) Show orders.");
        System.out.println("(4.) Show categories.");
        System.out.println("(5.) Logout");
    }
    public void adminProductsMenu() {

        System.out.println("(1.) Add product");
        System.out.println("(2.) Edit product");
        System.out.println("(3.) Remove product");
        System.out.println("(4.) Back");
    }
    public void adminOrdersMenu() {

        System.out.println("(1.) Edit order");
        System.out.println("(2.) Remove order");
        System.out.println("(3.) Back");
    }
    public void adminCategoriesMenu() {

        System.out.println("(1.) Add category");
        System.out.println("(2.) Edit category");
        System.out.println("(3.) Remove product");
        System.out.println("(4.) Back");
    }


}
