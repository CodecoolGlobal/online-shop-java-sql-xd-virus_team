package com.codecool.xdvirus.onlineShop.controller;

import com.codecool.xdvirus.onlineShop.ProductIterator;
import com.codecool.xdvirus.onlineShop.dao.BasketDao;
import com.codecool.xdvirus.onlineShop.dao.ProductDao;
import com.codecool.xdvirus.onlineShop.model.Basket;
import com.codecool.xdvirus.onlineShop.view.CustomerView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerController {

    CustomerView view = new CustomerView();
    ProductDao pD = new ProductDao();
    ProductIterator iter = new ProductIterator(pD.readContent());

    public void mainMenuController() {

        view.customerMainMenu();
        Scanner scanner = new Scanner(System.in);

        try {
            int choice = scanner.nextInt();
            if (choice > 0 && choice < 6) {
                switch (choice) {

                    case 1:
                        view.allProductsTable();
                        view.addProdToBasket();
                        addProductToBasketMenu();
                        break;
                    case 2:
                        view.chooseCategoryMenu();
                        chooseCategoryController();
                        break;
                    case 3:
                        view.addProdToBasket();
                        break;
                    case 4:
                        view.basketTable();
                        view.basketOptions();
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

    public void addProductToBasket() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter products name: ");
        System.out.println(">>");
        String productName = scanner.nextLine();
        //ProductIterator productIterator = new ProductIterator(pD.readContent());

        for (int i = 0; i < pD.readContent().size(); i++) {
            if (pD.readContent().get(i).getName().equals(productName)) {
                System.out.println("Enter quantity: ");
                int productAmount = scanner.nextInt();
                if (pD.readContent().get(i).getAmount() >= productAmount) {
                    Basket basket = new Basket(pD.readContent().get(i).getId(), productAmount);

                    BasketDao newbasket = new BasketDao();

                    newbasket.createContent(basket);
                    System.out.println("Product added");
                }
            }
        }

    }


    public void addProductToBasketMenu() {

        Scanner scanner = new Scanner(System.in);

        try {
            int choice = scanner.nextInt();
            if (choice > 0 && choice < 3) {
                switch (choice) {

                    case 1:
                        addProductToBasket();
                        break;
                    case 2:
                        break;//TODO back to main menu
                }
            } else {
                System.out.println("Enter number from 1 to 2");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");

        }

    }

    public void chooseCategoryController() {

        Scanner scanner = new Scanner(System.in);

        try {
            int choice = scanner.nextInt();
            if (choice >= 0 && choice < 5) {
                switch (choice) {

                    case 0:
                        view.categoryTable(choice);
                        view.addProdToBasket();
                        addProductToBasketMenu();
                        break;
                    case 1:
                        view.categoryTable(choice);
                        view.addProdToBasket();
                        addProductToBasketMenu();
                        break;
                    case 2:
                        view.categoryTable(choice);
                        view.addProdToBasket();
                        addProductToBasketMenu();
                        break;
                    case 3:
                        view.categoryTable(choice);
                        view.addProdToBasket();
                        addProductToBasketMenu();
                        break;
                    case 4:
                        view.categoryTable(choice);
                        view.addProdToBasket();
                        addProductToBasketMenu();
                        break;
                }
            } else {
                System.out.println("Enter number from 0 to 4");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");

        }

    }

    public static void main(String[] args) {
        CustomerController cstm = new CustomerController();
        cstm.mainMenuController();
    }


}



