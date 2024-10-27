package org.epam;

import java.util.Map;

public class Consumer extends Thread {

    private final WareHouse wareHouse;
    private final Products product;

    public Consumer(WareHouse wareHouse, Products product) {
        this.wareHouse = wareHouse;
        this.product = product;
    }

    public void run() {
        try {
            while (true) {
                int quantity = (int) (Math.random() * 15);
                wareHouse.takeProduct(product, quantity);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
