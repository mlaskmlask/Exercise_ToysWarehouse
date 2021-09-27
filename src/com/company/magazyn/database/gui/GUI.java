package com.company.magazyn.database.gui;

import com.company.magazyn.database.ProductRepository;
import com.company.magazyn.database.model.Doll;
import com.company.magazyn.database.model.Mascot;
import com.company.magazyn.database.model.Product;

import java.util.List;
import java.util.Scanner;

public class GUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("1. Dodaj produkt");
        System.out.println("2. Wydaj produkt");
        System.out.println("3. Wyświetl produkty");
        System.out.println("4. Wyjście");

        switch (scanner.nextLine()) {
            case "1":
                addProduct();
                mainMenu();
                break;
            case "2":
                deliverProduct();
                mainMenu();
                break;
            case "3":
                showAllProducts();
                mainMenu();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Nieprawidłowy wybór");
                mainMenu();
        }

    }

    private static void showAllProducts() {
        ProductRepository baza = ProductRepository.getInstance();
        List<Product> productList = baza.getProducts();
        for (Product currentProduct : productList) {
            System.out.println(currentProduct);
        }
    }

    private static void deliverProduct() {
        System.out.println("Podaj nazwę produktu:");
        String productToDeliver = scanner.nextLine();
        System.out.println("Podaj ilość sztuk:");
        int piecesToDeliver = Integer.parseInt(scanner.nextLine());
        ProductRepository baza = ProductRepository.getInstance();
        Boolean success = baza.deliverProduct(productToDeliver, piecesToDeliver);
        if (success) {
            System.out.println("Wydano produkt. ");
        } else {
            System.out.println("Nie udało się wydać produktu. ");
        }
    }

    private static void addProduct() {
        System.out.println("Podaj nazwę produktu:");
        String productName = scanner.nextLine();
        Product productFromDatabase = ProductRepository.getInstance().findProduct(productName);
        if (productFromDatabase != null) {
            System.out.println("Podaj ilość:");
            int piecesAdded = Integer.parseInt(scanner.nextLine());
            productFromDatabase.setPieces(productFromDatabase.getPieces() + piecesAdded);
            System.out.println("Dodano produkt!");
        } else {
            addNewProduct(productName);
        }
    }

    public static void addNewProduct(String productName) {
        System.out.println("1. Mascot");
        System.out.println("2. Doll");
        String choose = scanner.nextLine();
        DataWrapper dataWrapper;
        switch (choose) {
            case "1":
                dataWrapper = readCommonData();
                System.out.println("Podaj miękkość:");
                String sotness = scanner.nextLine();
                Mascot mascot = new Mascot(dataWrapper.size, productName, dataWrapper.pieces, sotness);
                ProductRepository.getInstance().addProductToDataBase(mascot);
                System.out.println("Produkt dodany!");
                break;
            case "2":
                dataWrapper =readCommonData();
                System.out.println("Podaj kolor:");
                String color = scanner.nextLine();
                Doll doll = new Doll(dataWrapper.size, productName, dataWrapper.pieces, color);
                ProductRepository.getInstance().addProductToDataBase(doll);
                System.out.println("Produkt dodany!");
                break;
            default:
                System.out.println("Nieprawidłowy wybór!");
                addNewProduct(productName);
                break;
        }
    }

    private static DataWrapper readCommonData() {
        System.out.println("Podaj wielkość:");
        String size = scanner.nextLine();
        System.out.println("Podaj ilość sztuk:");
        int pieces = Integer.parseInt(scanner.nextLine());
        return new DataWrapper(size, pieces);
    }

    static class DataWrapper {
        String size;
        int pieces;

        DataWrapper(String size, int pieces) {
            this.size = size;
            this.pieces = pieces;
        }
    }
}
