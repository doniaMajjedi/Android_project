package com.example.project_android;

import java.util.List;

public class ShoppingCart {
    private List<Fruit> items;

    public ShoppingCart(List<Fruit> items) {
        this.items = items;
    }

    public List<Fruit> getItems() {
        return items;
    }

    public void setItems(List<Fruit> items) {
        this.items = items;
    }

    public void addItem(Fruit item) {
        items.add(item);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Fruit fruit : items) {
            total += fruit.getPrice();
        }
        return total;
    }
}