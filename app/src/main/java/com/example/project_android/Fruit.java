package com.example.project_android;

public class Fruit {
    private int name;
    private String category;
    private double price;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Fruit(int name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // getters and setters for name, category, and price
}