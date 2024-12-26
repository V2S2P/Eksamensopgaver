package Opgave1_IndkøbksKurven;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();

        Product clothes = new Clothes(10, "black", "T-Shirt", 49.85);
        Product clothes1 = new Clothes(8,"brown","Pants", 88.00);
        basket.addProduct(clothes);
        basket.addProduct(clothes1);


        Product electronics = new Electronics(20, "Headset", 100);
        Product electronics1 = new Electronics(5, "Keyboard", 255);
        basket.addProduct(electronics);
        basket.addProduct(electronics1);


        Product food = new Food("01 January 2025", "Milk", 1.75);
        basket.addProduct(food);


        basket.printAll();
    }
}