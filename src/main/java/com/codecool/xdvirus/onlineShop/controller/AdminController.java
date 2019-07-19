package com.codecool.xdvirus.onlineShop.controller;

import com.codecool.xdvirus.onlineShop.ProductIterator;
import com.codecool.xdvirus.onlineShop.dao.CategoryDao;
import com.codecool.xdvirus.onlineShop.dao.ProductDao;
import com.codecool.xdvirus.onlineShop.model.Category;
import com.codecool.xdvirus.onlineShop.model.Product;
import com.codecool.xdvirus.onlineShop.view.AdminView;
import com.codecool.xdvirus.onlineShop.view.CustomerView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminController {
    ProductDao pD = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();
    AdminView view = new AdminView();
    CustomerView customerView = new CustomerView();

    public void mainMenuController() {
        view.adminMainMenu();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productMenuController();
                    break;
                case 2:
                    CategoriesMenuController();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Enter number from 1 to 3");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");
        }
    }

    public void CategoriesMenuController() {
        showAllCategories();
        view.adminCategoriesMenu();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice > 0 && choice < 6) {
                switch (choice) {
                    case 1:
                        addCategory();
                        break;
                    case 2:
                        editCategory();
                        break;
                    case 3:
                        removeCategory();
                        break;
                    case 4:
                        mainMenuController();
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
        customerView.allProductsTable();
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
            enterPrice();
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
            enterAmount();
        }
        return amount;
    }

    public String enterAvailibility() {
        Scanner scanner = new Scanner(System.in);
        String availibility = "";
        try {
            System.out.println("Enter availibility. (true/false)");
            availibility = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Enter availibility. (true/false)");
        }
        return availibility;
    }

    public int enterCategory() {
        Scanner scanner = new Scanner(System.in);
        int category = 0;
        System.out.println("Choose category: ");
        CategoryDao cD = new CategoryDao();
        showAllCategories();
        try {
            category = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter number");
            enterCategory();
        }
        return category;
    }

    public void addProduct() {
        Product newProduct = new Product(enterName(), enterPrice(), enterAmount(), enterAvailibility(), enterCategory());
        pD.createContent(newProduct);
        mainMenuController();
    }

    public void editProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter products name to edit: ");
        System.out.println(">>");
        String productName = scanner.nextLine();

        for (int i = 0; i < pD.readContent().size(); i++) {
            if (pD.readContent().get(i).getName().equals(productName)) {
                Product editedProduct;
                editedProduct = pD.readContent().get(i);
                editedProduct.setName(enterName());
                editedProduct.setPrice(enterPrice());
                editedProduct.setAmount(enterAmount());
                editedProduct.setAvailibility(enterAvailibility());
                editedProduct.setCategory(enterCategory());
                pD.updateContent(editedProduct);
            }
        }
        mainMenuController();
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter index of product to be removed: ");
        try {
            pD.removeContent(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Please enter number");
        }
        mainMenuController();
    }

    public void showAllCategories() {
        for (int i = 0; i < categoryDao.readContent().size(); i++) {
            System.out.println(categoryDao.readContent().get(i));
        }
    }

    public void addCategory() {
        Category newCategory = new Category(enterName());
        categoryDao.createContent(newCategory);
        mainMenuController();
    }

    public void editCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter category name to edit: ");
        System.out.println(">>");
        String categoryName = scanner.nextLine();
        for (int i = 0; i < categoryDao.readContent().size(); i++) {
            if (categoryDao.readContent().get(i).getName().equals(categoryName)) {
                Category editedCategory;
                editedCategory = categoryDao.readContent().get(i);
                editedCategory.setName(enterName());
                categoryDao.updateContent(editedCategory);
            }
        }
        mainMenuController();
    }

    public void removeCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter index of category to be removed: ");
        try {
            categoryDao.removeContent(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Please enter number");
            mainMenuController();
        }
    }

    public static void main(String[] args) {
        AdminController adm = new AdminController();
        adm.mainMenuController();
    }
}