package org.epam;

public class Main {
    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();

        Producer producer1 = new Producer(wareHouse, Products.CLOTHES);
        Consumer consumer1 = new Consumer(wareHouse, Products.CLOTHES);

        Producer producer2 = new Producer(wareHouse, Products.FOODS);
        Consumer consumer2 = new Consumer(wareHouse, Products.FOODS);

        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();
    }
}