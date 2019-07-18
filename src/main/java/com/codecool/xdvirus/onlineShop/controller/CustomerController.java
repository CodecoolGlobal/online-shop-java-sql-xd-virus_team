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
    ProductDao productDao = new ProductDao();
    ProductIterator iter = new ProductIterator(productDao.readContent());
    BasketDao basketDao = new BasketDao();

    public void mainMenuController() {

        view.customerMainMenu();
        Scanner scanner = new Scanner(System.in);

        try {
            boolean isChoosing = true;
            while (isChoosing) {
                int choice = scanner.nextInt();
                switch (choice) {

                    case 1:
                        view.allProductsTable();
                        view.addProdToBasket();
                        addProductToBasketMenu();
                        isChoosing = false;
                        break;
                    case 2:
                        view.chooseCategoryMenu();
                        chooseCategoryController();
                        isChoosing = false;
                        break;
                    case 3:
                        view.addProdToBasket();
                        isChoosing = false;
                        break;
                    case 4:
                        view.basketTable();
                        view.basketOptions();
                        basketEditMenu();
                        isChoosing = false;
                        break;
                    case 5:
                        isChoosing = false;
                        break;
                    default:
                        System.out.println("Enter number from 1 to 5\"");
                }
            }

        } catch (
                InputMismatchException e) {
            System.out.println("Please enter a number");
            mainMenuController();
        }

    }

    public void addProductToBasket() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter products name: ");
        System.out.println(">>");
        String productName = scanner.nextLine();
        //ProductIterator productIterator = new ProductIterator(productDao.readContent());

        for (int i = 0; i < productDao.readContent().size(); i++) {
            if (productDao.readContent().get(i).getName().equals(productName)) {
                System.out.println("Enter quantity: ");
                int productAmount = scanner.nextInt();
                if (productDao.readContent().get(i).getAmount() >= productAmount) {
                    Basket basket = new Basket(productDao.readContent().get(i).getId(), productAmount);

                    BasketDao newbasket = new BasketDao();

                    newbasket.createContent(basket);
                    System.out.println("Product added");
                }
            }
        }

    }


    public void addProductToBasketMenu() {

        /*Choose an action:
            (1.) Add product to basket.
            (2.) Back to main menu. */

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

        /*Choose category:
            (0.) 0 Vegetables
            (1.) 1 Fruits
            (2.) 2 Pastry
            (3.) 3 Dairy
            (4.) 4 Drinks*/

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

    public void basketEditMenu() {

        /*Choose an action:
            (1.) Place an order.
            (2.) Edit quantity.
            (3.) Delete product.
            (4.) Back to main menu. */

        Scanner scanner = new Scanner(System.in);

        try {
            int choice = scanner.nextInt();
            if (choice >= 0 && choice < 5) {
                switch (choice) {

                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        deleteProductFromBasket();
                        break;
                    case 4:
                        //TODO back to main menu
                        break;

                }
            } else {
                System.out.println("Enter number from 0 to 4");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");

        }

    }

    public void deleteProductFromBasket() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose items name: ");
        System.out.println(">> ");
        String itemsName = scanner.nextLine();

        for (int i = 0; i < productDao.readContent().size(); i++) {
            if (itemsName.equals(productDao.readContent().get(i).getName())) {
                int productsId = productDao.readContent().get(i).getId();
                for (int j = 0; j < basketDao.readContent().size(); j++) {
                    if (productsId == basketDao.readContent().get(j).getProduct_id()) {
                        int itemInBasketId = basketDao.readContent().get(j).getId();
                        basketDao.removeContent(itemInBasketId);
                        System.out.println("Item deleted");

                    }

                }


            }

        }

    }
/*
    public void placeOrder(){

        basketDao.Order newOrder = new Order();
    }

    public static void main(String[] args) {
        CustomerController cstm = new CustomerController();
        cstm.mainMenuController();
    }

*/
}



