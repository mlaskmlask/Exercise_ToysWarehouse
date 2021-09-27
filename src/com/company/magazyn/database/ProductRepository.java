package com.company.magazyn.database;

import com.company.magazyn.database.model.Doll;
import com.company.magazyn.database.model.Mascot;
import com.company.magazyn.database.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> products = new ArrayList<>();
    private static final ProductRepository productRepository = new ProductRepository();

    private ProductRepository() {
        Mascot mascot1 = new Mascot("big", "Uszatek", 10, "very soft");
        Mascot mascot2 = new Mascot("small", "Reksio", 20, "soft");
        Doll doll1 = new Doll("small", "Barbie", 20, "pink");
        Doll doll2 = new Doll("big", "Veronica", 30, "violet");

        this.products.add(mascot1);
        this.products.add(mascot2);
        this.products.add(doll1);
        this.products.add(doll2);
    }

    public static ProductRepository getInstance() {
        return productRepository;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public boolean deliverProduct(String productName, int pieces) {
        for (Product currentProduct : this.products) {
            if (currentProduct.getName().equals(productName) && currentProduct.getPieces() >= pieces) {
                currentProduct.setPieces(currentProduct.getPieces() - pieces);
                return true;
            }
        }
        return false;
    }

    public Product findProduct(String productName) {
        for (Product currentProduct : this.products){
            if(currentProduct.getName().equals(productName)){
                return currentProduct;
            }
        }
        return null;
    }
    public void addProductToDataBase(Product product){
        this.products.add(product);
    }
}
