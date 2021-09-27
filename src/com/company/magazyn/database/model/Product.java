package com.company.magazyn.database.model;

public class Product {
    private String size;
    private String name;
    private int pieces;

    public Product(String size, String name, int pieces) {
        this.size = size;
        this.name = name;
        this.pieces = pieces;
    }

    public Product() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "size='" + size + '\'' +
                ", name='" + name + '\'' +
                ", pieces=" + pieces + " ";
    }
}
