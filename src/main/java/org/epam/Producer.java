package org.epam;


public class Producer extends Thread {

    private final WareHouse wareHouse;
    private final Products product;

    public Producer(WareHouse wareHouse, Products product) {
        this.wareHouse = wareHouse;
        this.product = product;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int quantity = (int) (Math.random() * 10);
                wareHouse.addProduct(product, quantity);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
