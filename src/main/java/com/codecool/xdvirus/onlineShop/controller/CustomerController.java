package com.codecool.xdvirus.onlineShop.controller;

import com.codecool.xdvirus.onlineShop.ProductIterator;
import com.codecool.xdvirus.onlineShop.dao.BasketDao;
import com.codecool.xdvirus.onlineShop.dao.OrderDao;
import com.codecool.xdvirus.onlineShop.dao.ProductDao;
import com.codecool.xdvirus.onlineShop.dao.Sql;
import com.codecool.xdvirus.onlineShop.model.Basket;
import com.codecool.xdvirus.onlineShop.model.Order;
import com.codecool.xdvirus.onlineShop.model.Product;
import com.codecool.xdvirus.onlineShop.view.CustomerView;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerController {

    CustomerView view = new CustomerView();
    ProductDao pD = new ProductDao();
    BasketDao bD = new BasketDao();
    OrderDao oD = new OrderDao();
    Order currnentOrder;

    public void mainMenuController() {

        /*(1.) Show all products.
            ( 2.) Choose products category.
            (3.) Show all available products.
            (4.) Show my basket.
            (5.) Show my orders. */

        view.customerMainMenu();
        boolean isOn = true;


        while (isOn) {
            int userInput = new CustomerView().validateUserInput();
            switch (userInput) {

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
                    view.availableProductsTable();
                    view.addProdToBasket();
                    addProductToBasketMenu();
                    break;
                case 4:
                    view.basketTable();
                    view.basketOptions();
                    basketEditMenu();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Input must be a number between 1 and 5");
            }
        }

    }


    public void addProductToBasket() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter products name: ");
        System.out.println(">>");
        String productName = scanner.nextLine();

        Product product = pD.getByName(productName);
        if (product.getName().equals(productName)) {
            System.out.println("Enter quantity: ");
            int productAmount = scanner.nextInt();
            if (product.getAmount() >= productAmount) {
                Basket basket = new Basket(product.getId(), productAmount);
                bD.createContent(basket);
                System.out.println("Product added");
                mainMenuController();

            }
        }

    }


    public void addProductToBasketMenu() {

        /*Choose an action:
            (1.) Add product to basket.
            (2.) Back to main menu. */

        boolean isOn = true;

        while (isOn) {
            int userInput = new CustomerView().validateUserInput();
            switch (userInput) {

                case 1:
                    addProductToBasket();
                    break;
                case 2:
                    mainMenuController();
                    break;
                default:
                    System.out.println("Input must be a number between 1 and 2");

            }
        }

    }

    public void chooseCategoryController() {

        /*Choose category:
            (0.) 0 Vegetables
            (1.) 1 Fruits
            (2.) 2 Pastry
            (3.) 3 Dairy
            (4.) 4 Drinks*/

        boolean isOn = true;


        while (isOn) {
            int userInput = new CustomerView().validateUserInput();

            switch (userInput) {

                case 0:
                    chooseCategoryOption(userInput);
                    break;
                case 1:
                    chooseCategoryOption(userInput);

                    break;
                case 2:
                    chooseCategoryOption(userInput);

                    break;
                case 3:
                    chooseCategoryOption(userInput);

                    break;
                case 4:
                    chooseCategoryOption(userInput);

                    break;
                default:
                    System.out.println("Input must be a number between 1 and 5");
            }
        }

    }

    public void basketEditMenu() {

        /*Choose an action:
            (1.) Place an order.
            (2.) Edit quantity.
            (3.) Delete product.
            (4.) Back to main menu. */

        boolean isOn = true;


        int userInput = new CustomerView().validateUserInput();

        switch (userInput) {

            case 0:

                break;
            case 1:
                changeOrderStatus();
                mainMenuController();
                break;
            case 2:
                changeItemsQuantityInBasket();
                break;
            case 3:
                deleteProductFromBasket();
                break;
            case 4:
                mainMenuController();
                break;
            default:
                System.out.println("Input must be a number between 1 and 4");

        }

    }

    public void deleteProductFromBasket() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose items name: ");
        System.out.println(">> ");
        String itemsName = scanner.nextLine();

        Product product = pD.getByName(itemsName);
        bD.removeByProductId(product.getId());
        System.out.println("Item deleted");
        mainMenuController();

    }


    public void changeItemsQuantityInBasket() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter products name: ");
        System.out.println(">>");
        String productName = scanner.nextLine();

        Product product = pD.getByName(productName);
        bD.removeByProductId(product.getId());
        System.out.println("Item deleted");

        if (product.getName().equals(productName)) {
            System.out.println("Enter quantity: ");
            int productAmount = scanner.nextInt();
            if (product.getAmount() >= productAmount) {
                Basket basket = new Basket(product.getId(), productAmount);
                bD.createContent(basket);
                System.out.println("Product added");
                mainMenuController();


            }

        }
    }


    public void chooseCategoryOption(int userInput) {

        view.categoryTable(userInput);
        view.addProdToBasket();
        addProductToBasketMenu();
    }
    public void changeOrderStatus(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter products name: ");
        System.out.println(">>");

        String productName = scanner.nextLine();
        Product product = pD.getByName(productName);
        int productId = product.getId();
        Basket prodInbasket = bD.getById(productId);

        int productAmountInBasket = prodInbasket.getQuantity_of_product();

        if(product.getAmount()>=productAmountInBasket) {
            product.setAmount(product.getAmount() - productAmountInBasket);
            pD.updateContent(product);
            prodInbasket.setStatus("Paid");
            bD.updateContent(prodInbasket);

        }else{
            System.out.println("Not enough items in stock, to place order. Change items quantity.");
        }


    }

    public static void main(String[] args) {
        CustomerController cstm = new CustomerController();
        cstm.mainMenuController();
    }


}








