package com.codecool.xdvirus.onlineShop.view;

import com.codecool.xdvirus.onlineShop.ProductIterator;
import com.codecool.xdvirus.onlineShop.dao.BasketDao;
import com.codecool.xdvirus.onlineShop.dao.CategoryDao;
import com.codecool.xdvirus.onlineShop.dao.ProductDao;
import com.codecool.xdvirus.onlineShop.model.Category;

import java.util.Scanner;

public class CustomerView {


    private int userIntegerInput;

    ProductDao products = new ProductDao();
    CategoryDao category = new CategoryDao();
    BasketDao basket = new BasketDao();


    public void customerMainMenu() {

        System.out.println("Hello! You are logged as a customer");
        System.out.println("-----------------------------------");
        System.out.println("(1.) Show all products.");
        System.out.println("(2.) Choose products category. ");
        System.out.println("(3.) Show all available products. ");
        System.out.println("(4.) Show my basket. ");
        System.out.println("(5.) Show my orders. ");
    }

    public void addProdToBasket() {

        System.out.println("Choose an action: ");
        System.out.println("(1.) Add product to basket. ");
        System.out.println("(2.) Back to main menu. ");
    }

    public void basketOptions() {

        System.out.println("Choose an action: ");
        System.out.println("(1.) Place an order. ");
        System.out.println("(2.) Edit quantity. ");
        System.out.println("(3.) Delete product. ");
        System.out.println("(4.) Back to main menu. ");


    }

    public void allProductsTable() {


        System.out.println("----------------------------------------------ALL PRODUCTS--------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("  |" + "Name                |category            |quantity            |price               |is item available");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        int maxColumnSize = 20;
        String emptySpace = " ";

        for (int i = 0; i < products.readContent().size(); i++) {
            String name = products.readContent().get(i).getName();
            int categories = products.readContent().get(i).getCategory();
            int quantity = products.readContent().get(i).getAmount();
            double price = products.readContent().get(i).getPrice();
            String availibility = products.readContent().get(i).isAvailable();


            int maxColumnSizeMinusNameSize = maxColumnSize - name.length();
            String distanceName = stringMultiply(emptySpace, maxColumnSizeMinusNameSize);

            int maxColumnSizeMinusCategorySize = maxColumnSize - Integer.toString(categories).length();
            String distanceCategory = stringMultiply(emptySpace, maxColumnSizeMinusCategorySize);

            int maxColumnSizeMinusQuantitySize = maxColumnSize - Integer.toString(quantity).length();
            String distanceQuantity = stringMultiply(emptySpace, maxColumnSizeMinusQuantitySize);

            double maxColumnSizeMinusPriceSize = maxColumnSize - Double.toString(price).length();
            String distancePrices = stringMultiplyDouble(emptySpace, maxColumnSizeMinusPriceSize);

            System.out.println(i + ".|" + name + distanceName + "|" + categories + distanceCategory + "|" + quantity + distanceQuantity + "|" + price + distancePrices + "|" + availibility);
        }

    }

    public void categoryTable(int categoryId) {

        String categoryName = category.readContent().get(categoryId).getName();


        System.out.println("---------------------------------" + categoryName + "----------------------------------");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("  |Name                |quantity            |price               |is item available");
        System.out.println("-----------------------------------------------------------------------------------");


        int maxColumnSize = 20;
        String emptySpace = " ";

        for (int i = 1; i < products.readContent().size(); i++) {

            String name = products.readContent().get(i).getName();
            int category = products.readContent().get(i).getCategory();
            int quantity = products.readContent().get(i).getAmount();
            double price = products.readContent().get(i).getPrice();
            String availibility = products.readContent().get(i).isAvailable();

            if (products.readContent().get(i).getCategory() == categoryId) {


                int maxColumnSizeMinusNameSize = maxColumnSize - name.length();
                String distanceName = stringMultiply(emptySpace, maxColumnSizeMinusNameSize);

                int maxColumnSizeMinusCategorySize = maxColumnSize - Integer.toString(category).length();
                String distanceCategory = stringMultiply(emptySpace, maxColumnSizeMinusCategorySize);

                int maxColumnSizeMinusQuantitySize = maxColumnSize - Integer.toString(quantity).length();
                String distanceQuantity = stringMultiply(emptySpace, maxColumnSizeMinusQuantitySize);

                double maxColumnSizeMinusPriceSize = maxColumnSize - Double.toString(price).length();
                String distance = stringMultiplyDouble(emptySpace, maxColumnSizeMinusPriceSize);

                System.out.println(i + ".|" + name + distanceName + "|" + quantity + distanceQuantity + "|" + price + distanceQuantity + "|" + availibility);
            }
        }

    }


    public void chooseCategoryMenu() {

        System.out.println("Choose category: ");
        for (int i = 0; i < category.readContent().size(); i++) {
            System.out.println("(" + i + ".) " + category.readContent().get(i));


        }

    }

    public void basketTable() {


        System.out.println("------------------------YOUR BASKET-----------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("  |" + "Name                |" + "quantity            |" + "price               |status");
        System.out.println("----------------------------------------------------------------------------------------");

        int maxColumnSize = 20;
        String emptySpace = " ";

        for (int i = 1; i < basket.readContent().size(); i++) {
            int productID = basket.readContent().get(i).getProduct_id();
            int quantity = basket.readContent().get(i).getQuantity_of_product();
            String status = basket.readContent().get(i).getStatus();
            for (int j = 0; j < products.readContent().size(); j++) {

                if (products.readContent().get(j).getId() == productID) {
                    String name = products.readContent().get(j).getName();
                    double price = products.readContent().get(j).getPrice();
                    double priceSum = quantity * price;
                    int maxColumnSizeMinusNameSize = maxColumnSize - name.length();
                    String distanceName = stringMultiply(emptySpace, maxColumnSizeMinusNameSize);


                    int maxColumnSizeMinusQuantitySize = maxColumnSize - Integer.toString(quantity).length();
                    String distanceQuantity = stringMultiply(emptySpace, maxColumnSizeMinusQuantitySize);
                    double maxColumnSizeMinusPriceSize = maxColumnSize - Double.toString(priceSum).length();
                    String distancePrices = stringMultiplyDouble(emptySpace, maxColumnSizeMinusPriceSize);


                    System.out.println(" " + "|" + name + distanceName + "|" + quantity + distanceQuantity + "|" + priceSum + distancePrices+"|" + status);

                }


            }
        }
    }

    public void availableProductsTable() {

        System.out.println("----------------------------------------------ALL AVAILABLE PRODUCTS----------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("  |Name                |category            |quantity            |price               |is item available");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        int maxColumnSize = 20;
        String emptySpace = " ";

        for (int i = 1; i < products.readContent().size(); i++) {

            String name = products.readContent().get(i).getName();
            int categories = products.readContent().get(i).getCategory();
            int quantity = products.readContent().get(i).getAmount();
            double price = products.readContent().get(i).getPrice();
            String availibility = products.readContent().get(i).isAvailable();

            if (availibility.equals("true")) {

                int maxColumnSizeMinusNameSize = maxColumnSize - name.length();
                String distanceName = stringMultiply(emptySpace, maxColumnSizeMinusNameSize);

                int maxColumnSizeMinusCategorySize = maxColumnSize - Integer.toString(categories).length();
                String distanceCategory = stringMultiply(emptySpace, maxColumnSizeMinusCategorySize);

                int maxColumnSizeMinusQuantitySize = maxColumnSize - Integer.toString(quantity).length();
                String distanceQuantity = stringMultiply(emptySpace, maxColumnSizeMinusQuantitySize);

                double maxColumnSizeMinusPriceSize = maxColumnSize - Double.toString(price).length();
                String distancePrices = stringMultiplyDouble(emptySpace, maxColumnSizeMinusPriceSize);

                System.out.println(i + ".|" + name + distanceName + "|" + categories + distanceCategory + "|" + quantity + distanceQuantity + "|" + price + distancePrices + "|" + availibility);
            }
        }
    }


    public static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String stringMultiplyDouble(String s, double n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public int validateUserInput() {
        boolean isNotValid = true;
        while (isNotValid) {
            Scanner scanner = new Scanner(System.in);
            try {
                userIntegerInput = Integer.valueOf(scanner.nextLine());
                isNotValid = false;
            } catch (NumberFormatException e){
                System.out.println("Input must be a number");
        }
    }
        return userIntegerInput;
}

}
