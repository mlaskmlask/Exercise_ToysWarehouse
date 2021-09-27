package com.company.magazyn.database.model;

public class Mascot extends Product {
    private String softness;

    public Mascot(String size, String name, int pieces, String softness) {
        super(size, name, pieces);
        softness = softness;
    }

    public String getSoftness() {
        return softness;
    }

    public void setSoftness(String softness) {
        this.softness = softness;
    }

    @Override
    public String toString() {
        return "Mascot{" +
                super.toString()+
                "softness='" + softness + '\'' +
                '}';
    }
}
