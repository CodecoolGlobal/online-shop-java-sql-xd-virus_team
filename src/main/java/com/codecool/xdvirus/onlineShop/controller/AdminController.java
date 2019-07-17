package com.codecool.xdvirus.onlineShop.controller;

import com.codecool.xdvirus.onlineShop.dao.CategoryDao;
import com.codecool.xdvirus.onlineShop.dao.ProductDao;
import com.codecool.xdvirus.onlineShop.model.Product;
import com.codecool.xdvirus.onlineShop.view.AdminView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminController {

    ProductDao pD = new ProductDao();
    AdminView view = new AdminView();

    public void mainMenuController() {

        view.adminMainMenu();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice > 0 && choice < 6) {
                switch (choice) {

                    case 1:
                        productMenuController();
                        break;
                    case 2:
                        ordersMenuController();
                        break;
                    case 3:
                        break;
                    case 4:
                        view.adminCategoriesMenu();
                        break;
                    case 5:
                        break;
                }
            } else {
                System.out.println("Enter number from 1 to 5");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");

        }

    }

    public void productMenuController() {

        view.adminProductsMenu();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice > 0 && choice < 5) {
                switch (choice) {

                    case 1:
                        addProduct();
                        break;
                    case 2:
                        editProduct();
                        break;
                    case 3:
                        removeProduct();
                        break;
                    case 4:
                        mainMenuController();
                }
            } else {
                System.out.println("Enter number from 1 to 4");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");

        }

    }

    public void ordersMenuController() {

        view.adminOrdersMenu();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice > 0 && choice < 5) {
                switch (choice) {

                    case 1:
                        //editOrder();
                        break;
                    case 2:
                        //removeOrder();
                        break;
                    case 3:
                        mainMenuController();
                        break;
                }
            } else {
                System.out.println("Enter number from 1 to 4");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");

        }
    }

    public String enterName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        return name;
    }

    public double enterPrice() {
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        try {
            System.out.println("Enter price: ");
            price = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter number");
        }
        return price;
    }

    public int enterAmount() {
        Scanner scanner = new Scanner(System.in);
        int amount = 0;
        try {
            System.out.println("Enter amount: ");
            amount = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter number");
        }
        return amount;
    }

    public String enterAvailibility() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter availibility. (true/false)");
        String availibility = scanner.nextLine();

        return availibility;
    }

    public int enterCategory() {
        Scanner scanner = new Scanner(System.in);
        int category = 0;

        System.out.println("Choose category: ");
        CategoryDao cD = new CategoryDao();
        for (int index = 1; index < cD.readContent().size(); index++) {
            System.out.println(index + cD.readContent().indexOf(index));
        }
        try {
            category = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter string");
        }
        return category;
    }

    public void addProduct() {
        Product newProduct = new Product(enterName(), enterPrice(), enterAmount(), enterAvailibility(), enterCategory());
        pD.createContent(newProduct);
    }

    public void editProduct() {
        pD.updateContent(new Product(enterName(), enterPrice(), enterAmount(), enterAvailibility(), enterCategory()));
    }

    public void removeProduct() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter index of product to be removed: ");
        pD.removeContent(scanner.nextInt());

    }

    public static void main(String[] args) {
        AdminController adm = new AdminController();
        adm.mainMenuController();
    }


}
