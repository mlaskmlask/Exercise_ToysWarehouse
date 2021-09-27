package com.company.magazyn.database.model;

public class Doll extends Product {
    private String colour;

    public Doll(String size, String name, int pieces, String colour) {
        super(size, name, pieces);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Doll{" +
                super.toString()+
                "colour='" + colour + '\'' +
                '}';
    }
}
