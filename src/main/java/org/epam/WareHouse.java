package org.epam;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {
    private Map<Products, Integer> warehouse;

    public WareHouse() {
        warehouse = new HashMap<>();
        for (Products product : Products.values()) this.warehouse.put(product, 0);
    }

    public Map<Products, Integer> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Map<Products, Integer> warehouse) {
        this.warehouse = warehouse;
    }

    public synchronized void addProduct(Products product, int quantity) throws InterruptedException {
        while (warehouse.get(product) + quantity > product.getMaxCount()) {
            System.err.println("The warehouse is filled for " + product + ". Waiting for a seat to be made.");
            wait();
        }

        warehouse.put(product, warehouse.get(product) + quantity);
        System.out.println("Added " + quantity + " of " + product + ". Count now: " + warehouse.get(product));
        notifyAll();
    }

    public synchronized void takeProduct(Products product, int quantity) throws InterruptedException {
        while (warehouse.get(product) < quantity) {
            System.err.println("Not enough " + product + ". Waiting for adding");
            wait();
        }

        warehouse.put(product, warehouse.get(product) - quantity);
        System.out.println("Took " + quantity + " of " + product + ". Count now: " + warehouse.get(product));
        notifyAll();
    }
}
