package org.example;

public class Product {

    private String name;
    private int quantity;

    public Product(String name) {
        this.name = name;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity<1) this.quantity=1;
        else this.quantity = quantity;
    }
}